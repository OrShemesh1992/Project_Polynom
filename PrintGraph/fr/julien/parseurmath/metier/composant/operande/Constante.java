package fr.julien.parseurmath.metier.composant.operande;

public class Constante extends Operande{

	private String symbole;
		
	public Constante(String symbole, double valeur){
		super(valeur);
		this.symbole=symbole;
	}

	public String getSymbole() {
		return symbole;
	}
	
}
