package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class TanjenteHyperbolique extends AbstractFonction {

	private static final AbstractFonction instance = new TanjenteHyperbolique();
	
	private TanjenteHyperbolique(){
		super("th");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.tanh(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
