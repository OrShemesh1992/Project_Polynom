package fr.julien.graphique.element.forme;

import java.awt.Color;

public class OptionForme {
	
	
	private Color couleur;
	private boolean plein;
	
	/**
	 * @param couleur
	 * @param plein
	 */
	public OptionForme(Color couleur, boolean plein) {
		this.couleur = couleur;
		this.plein = plein;
	}

	public static OptionForme getDefault(){
		return new OptionForme(Color.BLUE, false);
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

	/**
	 * @return the plein
	 */
	public boolean isPlein() {
		return plein;
	}

	/**
	 * @param plein the plein to set
	 */
	public void setPlein(boolean plein) {
		this.plein = plein;
	}
	
	

}
