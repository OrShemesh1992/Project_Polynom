package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class CosinusHyperbolique extends AbstractFonction {

	private static final AbstractFonction instance = new CosinusHyperbolique();
	
	private CosinusHyperbolique(){
		super("ch");
	}
	
	public double resultat(double n1, double n2) throws CalculException {
		return Math.cosh(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
