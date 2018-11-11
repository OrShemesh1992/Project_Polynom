package fr.julien.parseurmath.metier;

import java.util.ArrayList;
import java.util.List;

import fr.julien.parseurmath.exception.AnalyseException;
import fr.julien.parseurmath.exception.MessageErreur;
import fr.julien.parseurmath.exception.SyntaxeException;
import fr.julien.parseurmath.metier.composant.Composants;
import fr.julien.parseurmath.metier.composant.IComposant;
import fr.julien.parseurmath.metier.composant.noeud.Noeud;
import fr.julien.parseurmath.metier.composant.operande.Operande;
import fr.julien.parseurmath.metier.operateur.IOperateur;

/**
 * <b>Analyseur permet de creer l'arbre representant l'equation.</b>
 *
 * @author Julien
 * @version 2.0
 */
public class Analyseur {

	/**
	 * L'unique instance de la classe
	 */
	private static final Analyseur instance = new Analyseur();

	/**
	 * Constructeur prive du singleton
	 */
	private Analyseur(){
		super();
	}

	/**
	 * Accesseur a l'unique instance d'analyseur
	 * @return l'analyseur
	 */
	public static final Analyseur getInstance(){
		return instance;
	}

	/**
	 * Cree l'arbre correspondant a l'equation
	 * @param equation
	 * 		equation a calculer
	 * @return l'arbre
	 * @throws AnalyseException si le format de l'equation n'est pas bon
	 */
	public Arbre creerArbre(String equation) throws AnalyseException {
		IComposant racine=null;
		try {
			racine = creerNoeudRacineSimple(equation);
		} 
		catch (AnalyseException e) {
			throw new AnalyseException(MessageErreur.ERREUR_CREATION_ARBRE, e);
		}
		return new Arbre(racine);
	}

	/**
	 * Fonction qui permet de creer le noeud racine de l'arbre
	 * @return le noeud racine
	 * @throws AnalyseException si le format de l'equation n'est pas le bon
	 */
	private IComposant creerNoeudRacineSimple(String equation) throws AnalyseException{
		IComposant res=null;
		try{
			if(isNumber(equation)){
				if(!isConst(equation)){
					res = new Operande(Double.parseDouble(equation));
				}
				else {
					res = Composants.getInstance().getConstante(equation);
				}
				
			}
			else {
				List<Integer> indices = rechercherIndiceOperateur(equation, 0, true);
				List<IOperateur> listeOperateurs = null;
				listeOperateurs=rechercherOperateur(equation, indices);
				if(indices.size()==0){
					indices = rechercherIndiceOperateur(equation, 0, false);
					listeOperateurs=rechercherOperateur(equation, indices);
				}
				if(indices.size()==0){
					if(getFonction(equation)==null){
						try {
							res=creerNoeudRacineSimple(equation.substring(1, equation.length()-1));
						}
						catch(AnalyseException e){
							throw new AnalyseException(MessageErreur.ERREUR_ANALYSE, e);
						}
					}
					else{
						IOperateur fonction = getFonction(equation);
						res=new Noeud(
								fonction,
								creerNoeudRacineSimple(
										equation.substring(fonction.getSymbole().length()+1, equation.length()-1)
								)
						);
					}
				}
				else{
					int k=0;
					for(int i=0; i<listeOperateurs.size(); i++){
						if(listeOperateurs.get(i).getSymbole().equals("*") || listeOperateurs.get(i).getSymbole().equals("/")){
							k=i;
						}
					}
					res=new Noeud(
							listeOperateurs.get(k),
							creerNoeudRacineSimple(equation.substring(0, indices.get(k))),
							creerNoeudRacineSimple(equation.substring(indices.get(k)+1, equation.length()))
					);
				}
			}
		}
		catch(AnalyseException e){
			throw new AnalyseException(MessageErreur.ERREUR_ANALYSE, e);
		}
		catch (SyntaxeException e) {
			throw new AnalyseException(MessageErreur.ERREUR_ANALYSE, e);
		}
		return res;
	}

	/**
	 * Fonction retournant vrai si le param�tre est un nombre
	 * @param s
	 * 		La chaine a verifier
	 * @return vrai si s est un nombre
	 */
	private boolean isNumber(String s){
		boolean res=true;
		if(s!=null && s.length()>0){

			for(int i=0; i<s.length(); i++){
				if(!"1234567890.".contains(s.charAt(i)+"")){
					res=false;
				}
			}
			for(String c : Composants.getInstance().getSymbolesConstantes()){
				if(s.equals(c)){
					res=true;
				}
			}
		}
		else {
			res=false;
		}
		return res;
	}
	
	public boolean isConst(String s){
		boolean res=false;
		for(String c : Composants.getInstance().getSymbolesConstantes()){
			if(s.equals(c)){
				res=true;
			}
		}
		return res;
	}

	/**
	 * Fonction permettant de recuperer une fonction dans une chaine
	 * @param s
	 * 		La chaine dans laquelle on veut recuperer la fonction
	 * @return La fonction a recuperer
	 */
	private IOperateur getFonction(String s){
		IOperateur res = null;
		for(IOperateur f : Composants.getInstance().getFonctions()){
			if(f.getSymbole().length()<s.length() && s.substring(0, f.getSymbole().length()).equals(f.getSymbole())){
				res=f;
				break;
			}
		}
		return res;
	}

	/**
	 * Fonction qui donne le nombre de parentheses ouvertes et non referm�es
	 * @param indice
	 * 		L'indice dont on recherche le niveau
	 * @param eq
	 * 		L'equation dans laquelle on recherche
	 * @return le niveau de parentheses
	 */
	private int getNiveau(int indice, String eq){
		int niveau=0;
		for(int i=0; i<indice; i++){
			if(eq.charAt(i)=="(".charAt(0)){
				niveau++;
			}
			else if(eq.charAt(i)==")".charAt(0)){
				niveau--;
			}
		}
		return niveau;
	}

	/**
	 * Fonction qui recherche l'indices des operateurs dans une chaine
	 * @param equation
	 * 		L'equation dans laquelle on recherche
	 * @param niveau
	 * 		Niveau de parentheses
	 * @param justeNP
	 * 		Booleen vrai si on ne veut que les operateurs non prioritaires
	 * @return La listes des positions des operateurs
	 */
	private List<Integer> rechercherIndiceOperateur(String equation, int niveau, boolean justeNP){
		List<Integer> liste = new ArrayList<Integer>();
		for(int i=0; i<equation.length(); i++){
			for(IOperateur op : Composants.getInstance().getOperateurs()){
				if((equation.charAt(i)+"").equals(op.getSymbole()) && getNiveau(i, equation)==niveau){
					if(!justeNP || !op.isPrioritaire()){
						liste.add(i);
					}
				}
			}
		}
		return liste;
	}

	/**
	 * Fonction qui recherche les op�rateurs dans une chaine
	 * @param equation
	 * 		L'equation dans laquelle on recherche
	 * @param indices
	 * 		Les indices des op�rateurs
	 * @return une liste des operateurs
	 */
	private List<IOperateur> rechercherOperateur(String equation, List<Integer> indices) throws AnalyseException{
		List<IOperateur> liste = new ArrayList<IOperateur>();
		for(Integer i : indices){
			try {
				liste.add(Composants.getInstance().getOperateur(equation.charAt(i)+""));
			} 
			catch (SyntaxeException e) {
				throw new AnalyseException(MessageErreur.ERREUR_OPERATEUR, e);
			}
		}
		return liste;
	}
}
