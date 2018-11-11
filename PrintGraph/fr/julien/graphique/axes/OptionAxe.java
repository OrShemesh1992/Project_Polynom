package fr.julien.graphique.axes;

import java.awt.Color;

public class OptionAxe {
	
	private Color couleur;
	private boolean afficherGraduations;
	private double departGraduation;
	private double pasGraduations;
	private boolean afficherValeurs;
	private boolean afficherOrientation;
	
	
	public static OptionAxe getDafault(){
		return new OptionAxe(Color.BLACK, false, 0, 0, false, false);
	}
	
	/**
	 * @param couleur
	 * @param afficherGraduations
	 * @param departGraduation
	 * @param afficherValeurs
	 * @param afficherOrientation
	 */
	public OptionAxe(Color couleur, boolean afficherGraduations,
			double departGraduation, double pasGraduations, boolean afficherValeurs,
			boolean afficherOrientation) {
		super();
		this.couleur = couleur;
		this.afficherGraduations = afficherGraduations;
		this.departGraduation = departGraduation;
		this.afficherValeurs = afficherValeurs;
		this.afficherOrientation = afficherOrientation;
		this.pasGraduations=pasGraduations;
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
	 * @return the afficherGraduations
	 */
	public boolean isAfficherGraduations() {
		return afficherGraduations;
	}

	/**
	 * @param afficherGraduations the afficherGraduations to set
	 */
	public void setAfficherGraduations(boolean afficherGraduations) {
		this.afficherGraduations = afficherGraduations;
	}

	/**
	 * @return the departGraduation
	 */
	public double getDepartGraduation() {
		return departGraduation;
	}

	/**
	 * @param departGraduation the departGraduation to set
	 */
	public void setDepartGraduation(double departGraduation) {
		this.departGraduation = departGraduation;
	}

	/**
	 * @return the afficherValeurs
	 */
	public boolean isAfficherValeurs() {
		return afficherValeurs;
	}

	/**
	 * @param afficherValeurs the afficherValeurs to set
	 */
	public void setAfficherValeurs(boolean afficherValeurs) {
		this.afficherValeurs = afficherValeurs;
	}

	/**
	 * @return the afficherOrientation
	 */
	public boolean isAfficherOrientation() {
		return afficherOrientation;
	}

	/**
	 * @param afficherOrientation the afficherOrientation to set
	 */
	public void setAfficherOrientation(boolean afficherOrientation) {
		this.afficherOrientation = afficherOrientation;
	}

	/**
	 * @return the pasGraduations
	 */
	public double getPasGraduations() {
		return pasGraduations;
	}

	/**
	 * @param pasGraduations the pasGraduations to set
	 */
	public void setPasGraduations(double pasGraduations) {
		this.pasGraduations = pasGraduations;
	}
	
	
	
	

}
