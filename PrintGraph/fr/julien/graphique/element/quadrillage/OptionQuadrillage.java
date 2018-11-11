package fr.julien.graphique.element.quadrillage;

import java.awt.Color;

public class OptionQuadrillage {
	
	private Color couleur;
	
	public static OptionQuadrillage getDefault(){
		return new OptionQuadrillage(Color.LIGHT_GRAY);
	}

	/**
	 * @param couleur
	 */
	public OptionQuadrillage(Color couleur) {
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
