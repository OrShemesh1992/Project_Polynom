package fr.julien.parseurmath.metier;

import fr.julien.parseurmath.exception.AnalyseException;
import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;
import fr.julien.parseurmath.exception.ParsingException;

/**
  * <b>ParseurMath est la classe qui permet de parser une equation pour en donner le resultat.</b>
  * <p>
  * Un ParseurMath permet de calculer le resultat d'une equation mathematique
  * </p>
  *
  * @author Julien
  * @version 2.0
  */
public class ParseurMath {

	/**
	  * L'unique instance du parseur
	  */
	private static final ParseurMath instance = new ParseurMath();
	
	/**
	  * L'analyseur qui permet de creer l'arbre
	  */
	private final Analyseur analyseur = Analyseur.getInstance();
	
	/**
	  * Constructeur prive du singleton
	  */
	private ParseurMath(){
		super();
	}
	
	/**
	  * Fonction qui permet de parser une equation pour en determiner le resultat
	  * @return Le resultat de l'equation
	  * @throws ParsingException si on ne parvient pas a parser l'equation
	  */
	public double parseDouble(String equation) throws ParsingException {
		double res = 0;
		try {
			Arbre arbre = analyseur.creerArbre(equation);
			res = arbre.calculer();
		}
		catch(AnalyseException e1) {
			throw new ParsingException(MessageErreur.ERREUR_PARSING_ARBRE);
		}
		catch(CalculException e2){
			throw new ParsingException(MessageErreur.ERREUR_CALCUL_ARBRE);
		}
		return res;
	}
	
	/**
	  * Accesseur a l'unique instance du parseur
	  * @return l'instance du parseur
	  */
	public static final ParseurMath getInstance(){
		return instance;
	}

}