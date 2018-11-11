package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class ValeurAbsolue extends AbstractFonction {

	private static final AbstractFonction instance = new ValeurAbsolue();
	
	private ValeurAbsolue(){
		super("abs");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.abs(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
