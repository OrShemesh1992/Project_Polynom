package fr.julien.parseurmath.metier.composant;

import fr.julien.parseurmath.exception.CalculException;

/**
  * <b>IComposant represente un composant de l'arbre : noeud ou operande.</b>
  * <p>
  * Un IComposant permet de calculer sa valeur
  * </p>
  *
  * @author Julien
  * @version 2.0
  */
public interface IComposant {
	
	/**
	  * Fonction qui permet de retourner la valeur du composant
	  * (Fonction recursive utilisant le pattern composite)
	  * @return Le resultat du calcul
	  */
	public double calculer() throws CalculException;
}
