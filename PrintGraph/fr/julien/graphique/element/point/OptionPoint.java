package fr.julien.graphique.element.point;

import java.awt.Color;

public class OptionPoint {
	
	private Color couleur;
	private boolean afficherNom;
	
	/**
	 * @param couleur
	 * @param afficherNom
	 * @param afficherTrace
	 */
	public OptionPoint(Color couleur, boolean afficherNom) {
		super();
		this.couleur = couleur;
		this.afficherNom = afficherNom;
	}

	public static OptionPoint getDefault(){
		return new OptionPoint(Color.BLACK, true);
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
	 * @return the afficherNom
	 */
	public boolean isAfficherNom() {
		return afficherNom;
	}

	/**
	 * @param afficherNom the afficherNom to set
	 */
	public void setAfficherNom(boolean afficherNom) {
		this.afficherNom = afficherNom;
	}
	
	
	

}
