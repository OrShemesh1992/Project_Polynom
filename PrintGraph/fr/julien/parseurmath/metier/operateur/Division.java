package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;


public class Division extends AbstractOperateur{
	
	private static final AbstractOperateur instance = new Division();
	
	private Division(){
		super("/");
	}
	
	public double resultat(double n1, double n2) throws CalculException {
		double res=0;
		if(n2==0){
			throw new CalculException(MessageErreur.ERREUR_DIVISION_ZERO);
		}
		else{
			res = n1/n2;
		}
		return res;
	}
	
	public boolean isPrioritaire(){
		return true;
	}
	
	public static final AbstractOperateur getInstance(){
		return instance;
	}
}
