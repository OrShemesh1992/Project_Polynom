package fr.julien.parseurmath.metier;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.metier.composant.IComposant;

/**
  * <b>Arbre represente l'arbre representant une �quation.</b>
  * <p>
  * Un arbre est caracterise par les inforamtions :
  * <ul>
  * <li>Le noeud racine de l'arbre</li>
  * </ul>
  * </p>
  * <p>
  * De plus, un arbre permet de recuperer le resultat de l'equation entree
  * </p>
  *
  * @author Julien
  * @version 2.0
  */
public class Arbre {
	
	/** 
	  * Le noeud racine definit l'arbre
	  */
	private IComposant racine;
	
	/**
	 * Constructeur de l'arbre
	 * @param n
	 * 		le noeud racine
	 */
	public Arbre(IComposant n){
		racine=n;
	}
	
	/**
	  * Fonction qui permet de donner le resultat du calcul
	  * @return Le resultat du calcul de l'arbre
	  * @throws CalculException si une erreur de calcul survient
	  */
	public double calculer() throws CalculException {
		return racine.calculer();
	}

}
