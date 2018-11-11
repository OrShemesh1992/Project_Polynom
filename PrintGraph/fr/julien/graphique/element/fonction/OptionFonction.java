package fr.julien.graphique.element.fonction;

import java.awt.Color;

public class OptionFonction {

	private Color couleur;

	public static OptionFonction getDefault(){
		return new OptionFonction(Color.green);
	}


	/**
	 * @param couleur
	 */
	public OptionFonction(Color couleur) {
		super();
		this.couleur = couleur;
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
