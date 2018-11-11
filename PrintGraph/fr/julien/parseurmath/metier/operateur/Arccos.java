package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;

public class Arccos extends AbstractFonction {

	private static final AbstractFonction instance = new Arccos();
	
	private Arccos(){
		super("arccos");
	}
	
	public double resultat(double n1, double n2) throws CalculException{
		double res=0;
		if(n1>1 || n1<-1){
			throw new CalculException(MessageErreur.ERREUR_ACOS);
		}
		else {
			res=Math.acos(n1);
		}
		return res;
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
