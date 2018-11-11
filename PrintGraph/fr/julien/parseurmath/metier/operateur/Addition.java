package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Addition extends AbstractOperateur {
	
	private static final AbstractOperateur instance = new Addition();
	
	private Addition(){
		super("+");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return n1+n2;
	}
	
	public boolean isPrioritaire(){
		return false;
	}
	
	public static final AbstractOperateur getInstance(){
		return instance;
	}

}
