package fr.julien.parseurmath.metier.composant.operande;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.metier.composant.IComposant;



public class Operande implements IComposant {

	/**
	  * la valeur de l'operande 
	  */
	private double valeur;
	
	/**
	 * Construit l'operande
	 * @param valeur 
	 * 		la valeur
	 */
	public Operande(double valeur){
		this.valeur=valeur;
	}

	public double getValeur() {
		return valeur;
	}

	public double calculer() throws CalculException{
		return valeur;
	}
	

}
