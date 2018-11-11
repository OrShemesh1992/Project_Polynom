package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Exponentielle extends AbstractFonction {

	private static final AbstractFonction instance = new Exponentielle();
	
	private Exponentielle(){
		super("exp");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.exp(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
