package fr.julien.graphique.element.vecteur;

import java.awt.Color;

public class OptionVecteur {
	
	private Color couleur;
	
	/**
	 * @param couleur
	 */
	public OptionVecteur(Color couleur) {
		super();
		this.couleur = couleur;
	}



	public static OptionVecteur getDefault(){
		return new OptionVecteur(Color.BLACK);
	}



	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}



	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
}
