package fr.julien.graphique.element.segment;

import java.awt.Color;

public class OptionSegment {

	private Color couleur;

	public static OptionSegment getDefault(){
		return new OptionSegment(Color.BLACK);
	}
	
	/**
	 * @param couleur
	 */
	public OptionSegment(Color couleur) {
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
