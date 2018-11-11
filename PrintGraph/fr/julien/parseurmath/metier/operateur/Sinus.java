package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Sinus extends AbstractFonction {

	private static final AbstractFonction instance = new Sinus();
	
	private Sinus(){
		super("sin");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.sin(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
