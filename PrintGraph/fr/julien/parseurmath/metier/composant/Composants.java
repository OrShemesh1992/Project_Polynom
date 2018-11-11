package fr.julien.parseurmath.metier.composant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.julien.parseurmath.exception.MessageErreur;
import fr.julien.parseurmath.exception.SyntaxeException;
import fr.julien.parseurmath.metier.composant.operande.Constante;
import fr.julien.parseurmath.metier.operateur.Addition;
import fr.julien.parseurmath.metier.operateur.Arccos;
import fr.julien.parseurmath.metier.operateur.Arcsin;
import fr.julien.parseurmath.metier.operateur.Arctan;
import fr.julien.parseurmath.metier.operateur.Cosinus;
import fr.julien.parseurmath.metier.operateur.CosinusHyperbolique;
import fr.julien.parseurmath.metier.operateur.Division;
import fr.julien.parseurmath.metier.operateur.Exponentielle;
import fr.julien.parseurmath.metier.operateur.IOperateur;
import fr.julien.parseurmath.metier.operateur.Log;
import fr.julien.parseurmath.metier.operateur.Logarithme;
import fr.julien.parseurmath.metier.operateur.Multiplication;
import fr.julien.parseurmath.metier.operateur.Normale;
import fr.julien.parseurmath.metier.operateur.Puissance;
import fr.julien.parseurmath.metier.operateur.Racine;
import fr.julien.parseurmath.metier.operateur.Sinus;
import fr.julien.parseurmath.metier.operateur.SinusHyperbolique;
import fr.julien.parseurmath.metier.operateur.Soustraction;
import fr.julien.parseurmath.metier.operateur.Tanjente;
import fr.julien.parseurmath.metier.operateur.TanjenteHyperbolique;
import fr.julien.parseurmath.metier.operateur.ValeurAbsolue;

/**
  * <b>Operateurs represente les operateur reconnus par le parseur.</b>
  * <p>
  * Un operateurs permet de recuperer les operateurs, leurs symboles...
  * </p>
  *
  * @author Julien
  * @version 2.0
  */
public class Composants {

	/**
	  * L'instance du singleton
	  */
	private static final Composants instance = new Composants();
	
	/**
	  * Toutes les fonctions reconnues
	  */
	private final Map<String, IOperateur> fonctions = new HashMap<String, IOperateur>();
	
	/**
	  * Tous les operateurs reconnus
	  */
	private final Map<String, IOperateur> operateurs = new HashMap<String, IOperateur>();
	
	/**
	  * Tous les constantes reconnues
	  */
	private final Map<String, Constante> constantes = new HashMap<String, Constante>();
	
	/**
	  * Constructeur prive du singleton
	  */
	private Composants(){
		/*fonctions*/
		List<IOperateur> f = new ArrayList<IOperateur>();
		f.add(Arccos.getInstance());
		f.add(Arcsin.getInstance());
		f.add(Arctan.getInstance());
		f.add(Cosinus.getInstance());
		f.add(CosinusHyperbolique.getInstance());
		f.add(Exponentielle.getInstance());
		f.add(Log.getInstance());
		f.add(Logarithme.getInstance());
		f.add(Normale.getInstance());
		f.add(Racine.getInstance());
		f.add(Sinus.getInstance());
		f.add(SinusHyperbolique.getInstance());
		f.add(Tanjente.getInstance());
		f.add(TanjenteHyperbolique.getInstance());
		f.add(ValeurAbsolue.getInstance());
		for(IOperateur fct : f){
			fonctions.put(fct.getSymbole(), fct);
		}
		/*operateurs*/
		List<IOperateur> op = new ArrayList<IOperateur>();
		op.add(Addition.getInstance());
		op.add(Soustraction.getInstance());
		op.add(Multiplication.getInstance());
		op.add(Division.getInstance());
		op.add(Puissance.getInstance());
		for(IOperateur o : op){
			operateurs.put(o.getSymbole(), o);
		}
		/*constantes*/
		List<Constante> co = new ArrayList<Constante>();
		co.add(new Constante("Pi", Math.PI));
		co.add(new Constante("e", Math.E));
		for(Constante c : co){
			constantes.put(c.getSymbole(), c);
		}
	}
	
	public static final Composants getInstance(){
		return instance;
	}
	
	public List<String> getSymbolesOperateurs(){
		List<String> res = new ArrayList<String>();
		res.addAll(operateurs.keySet());
		return res;
	}
	
	public List<String> getSymbolesFonctions(){
		List<String> res = new ArrayList<String>();
		res.addAll(fonctions.keySet());
		return res;
	}
	
	public List<String> getSymbolesConstantes(){
		List<String> res = new ArrayList<String>();
		res.addAll(constantes.keySet());
		return res;
	}
	
	public IOperateur getOperateur(String symbole) throws SyntaxeException{
		IOperateur res = null;
		if(operateurs.containsKey(symbole)){
			res = operateurs.get(symbole);
		}
		else {
			throw new SyntaxeException(MessageErreur.ERREUR_OPERATEUR_INEXISTANT);
		}
		return res;
	}
	
	public IOperateur getFonction(String symbole) throws SyntaxeException{
		IOperateur res = null;
		if(fonctions.containsKey(symbole)){
			res = fonctions.get(symbole);
		}
		else {
			throw new SyntaxeException(MessageErreur.ERREUR_OPERATEUR_INEXISTANT);
		}
		return res;
	}
	
	public Constante getConstante(String symbole) throws SyntaxeException{
		Constante res = null;
		if(constantes.containsKey(symbole)){
			res = constantes.get(symbole);
		}
		else {
			throw new SyntaxeException(MessageErreur.ERREUR_OPERATEUR_INEXISTANT);
		}
		return res;
	}
	
	public List<IOperateur> getOperateurs(){
		List<IOperateur> op = new ArrayList<IOperateur>();
		for(String s : operateurs.keySet()){
		op.add(operateurs.get(s));
		}
		return op;
	}
	
	public List<IOperateur> getFonctions(){
		List<IOperateur> fct = new ArrayList<IOperateur>();
		fct.addAll(fonctions.values());
		return fct;
	}
}
