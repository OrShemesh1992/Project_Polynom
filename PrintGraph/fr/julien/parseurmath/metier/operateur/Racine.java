package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;
import fr.julien.parseurmath.exception.MessageErreur;

public class Racine extends AbstractFonction {

	private static final AbstractFonction instance = new Racine();
	
	private Racine(){
		super("racine");
	}
	
	public double resultat(double n1, double n2) throws CalculException {
		double res=0;
		if(n1<0){
			throw new CalculException(MessageErreur.ERREUR_RACINE);
		}
		else {
			res = Math.sqrt(n1);
		}
		return res;
	}
	
	public static final AbstractFonction getInstance(){
		return instance;
	}
	
}
