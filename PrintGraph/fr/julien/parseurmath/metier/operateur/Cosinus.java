package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;

public class Cosinus extends AbstractFonction {

	private static final AbstractFonction instance = new Cosinus();
	
	private Cosinus(){
		super("cos");
	}
	
	public double resultat(double n1, double n2) throws CalculException {
		return Math.cos(n1);
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
