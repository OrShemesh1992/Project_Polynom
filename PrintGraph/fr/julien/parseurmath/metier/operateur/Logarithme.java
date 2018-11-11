package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;

public class Logarithme extends AbstractFonction {

	private static final AbstractFonction instance = new Logarithme();
	
	private Logarithme(){
		super("ln");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		double res = 0;
		if(n1<=0){
			throw new CalculException(MessageErreur.ERREUR_LN);
		}
		else {
			res = Math.log(n1);
		}
		return res;
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
