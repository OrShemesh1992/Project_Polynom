package fr.julien.parseurmath.metier.composant.noeud;

import java.util.ArrayList;
import java.util.List;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;
import fr.julien.parseurmath.metier.composant.IComposant;
import fr.julien.parseurmath.metier.operateur.IOperateur;


/**
  * <b>Noeud represente un noeud de l'arbre syntaxique de l'eqution.</b>
  * <p>
  * Un noeud est caracterise par les inforamtions :
  * <ul>
  * <li>Un operateur</li>
  * <li>Une liste de noeuds fils</li>
  * </ul>
  * </p>
  * <p>
  * De plus, un arbre permet de recuperer le resultat de l'equation entree
  * </p>
  *
  *
  * @author Julien
  * @version 2.0
  */
public class Noeud implements IComposant {

	/** 
	  * L'operateur du noeud
	  */
	private IOperateur operateur;
	
	/** 
	  * Les noeuds engendres par le noeud 
	  */
	private List<IComposant> noeudsFils;

	/**
	  * Constructeur a deux noeuds fils
	  * @param operateur
	  *		L'operateur du noeud
	  * @param a1
	  *		Le composant de la branche gauche
	  * @param a2
	  *		Le composant de la branche droite
	  */
	public Noeud(IOperateur operateur, IComposant a1, IComposant a2){
		this.operateur=operateur;
		noeudsFils = new ArrayList<IComposant>(2);
		getNoeudsFils().add(a1);
		getNoeudsFils().add(a2);
	}

	/**
	  * Constructeur a un noeud fils
	  * @param operateur
	  *		L'operateur du noeud
	  * @param a1
	  *		Le composant de la branche gauche
	  */
	public Noeud(IOperateur operateur, IComposant a1){
		this.operateur=operateur;
		noeudsFils = new ArrayList<IComposant>(2);
		getNoeudsFils().add(a1);
	}
	
	public double calculer() throws CalculException {
		double res;
		try{
			if(getNoeudsFils().size()==2){
				res = operateur.resultat(
						getNoeudsFils().get(0).calculer(), 
						getNoeudsFils().get(1).calculer()
				);
			}
			else{
				res=operateur.resultat(getNoeudsFils().get(0).calculer(),0);
			}
		}
		catch(CalculException e){
			throw new CalculException(MessageErreur.ERREUR_CALCUL, e);
		}
		return res;
	}

	public List<IComposant> getNoeudsFils() {
		return noeudsFils;
	}

	public IOperateur getOperateur() {
		return operateur;
	}


}
