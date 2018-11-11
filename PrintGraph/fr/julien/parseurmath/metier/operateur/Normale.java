package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Normale extends AbstractFonction {

	private static final AbstractFonction instance = new Normale();
	
	private Normale(){
		super("gauss");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.exp(-0.5*n1*n1)/Math.sqrt(2*Math.PI);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
