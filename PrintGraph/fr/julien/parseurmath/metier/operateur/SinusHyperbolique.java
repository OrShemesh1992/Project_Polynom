package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class SinusHyperbolique extends AbstractFonction {

	private static final AbstractFonction instance = new SinusHyperbolique();
	
	private SinusHyperbolique(){
		super("sh");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		return Math.sinh(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
