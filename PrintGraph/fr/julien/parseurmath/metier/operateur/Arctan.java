package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Arctan extends AbstractFonction {

	private static final AbstractFonction instance = new Arctan();
	
	private Arctan(){
		super("arctan");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.atan(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
