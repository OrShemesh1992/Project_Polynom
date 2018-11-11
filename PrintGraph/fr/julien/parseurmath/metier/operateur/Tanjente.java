package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;

public class Tanjente extends AbstractFonction {

	private static final AbstractFonction instance = new Tanjente();
	
	private Tanjente(){
		super("arctan");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		double res=0;
		try{
			res = Math.tan(n1);
		}
		catch(ArithmeticException e){
			throw new CalculException(MessageErreur.ERREUR_TANJENTE, e);
		}
		return res;
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
