package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Puissance extends AbstractOperateur{
	
	private static final AbstractOperateur instance = new Puissance();
	
	private Puissance(){
		super("^");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.pow(n1, n2);
	}
	
	public boolean isPrioritaire(){
		return true;
	}
	
	public static final AbstractOperateur getInstance(){
		return instance;
	}
	
}
