package fr.julien.graphique.element.vecteur;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.AbstractElementGraphique;

public class Vecteur extends AbstractElementGraphique {

	private static final long serialVersionUID = -6084389502548907175L;

	private char nom;
	private double abscisse;
	private double ordonnee;
	private OptionVecteur options;

	/**
	 * @param abscisse
	 * @param ordonnee
	 * @param options
	 */
	public Vecteur(char nom, double abscisse, double ordonnee, OptionVecteur options) {
		this.nom=nom;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.options = options;
	}

	/**
	 * @param abscisse
	 * @param ordonnee
	 */
	public Vecteur(double abscisse, double ordonnee) {
		this('u', abscisse, ordonnee, OptionVecteur.getDefault());
	}


	@Override
	public void dessiner(Graphique graphique) {
		if(abscisse>=0) {
			if(ordonnee>=0){
				setBounds(
						Outils.getInstance().determinerX(graphique, 0),
						Outils.getInstance().determinerY(graphique, ordonnee),
						Outils.getInstance().determinerX(graphique, abscisse)-Outils.getInstance().determinerX(graphique, 0),
						-Outils.getInstance().determinerY(graphique, ordonnee)+Outils.getInstance().determinerY(graphique, 0)
				);
			}
			else {
				setBounds(
						Outils.getInstance().determinerX(graphique, 0),
						Outils.getInstance().determinerY(graphique, 0),
						Outils.getInstance().determinerX(graphique, abscisse)-Outils.getInstance().determinerX(graphique, 0),
						Outils.getInstance().determinerY(graphique, ordonnee)-Outils.getInstance().determinerY(graphique, 0)
				);
			}
		}
		else {
			if(ordonnee>=0){
				setBounds(
						Outils.getInstance().determinerX(graphique, abscisse),
						Outils.getInstance().determinerY(graphique, ordonnee),
						-Outils.getInstance().determinerX(graphique, abscisse)+Outils.getInstance().determinerX(graphique, 0),
						-Outils.getInstance().determinerY(graphique, ordonnee)+Outils.getInstance().determinerY(graphique, 0)
				);
			}
			else {
				setBounds(
						Outils.getInstance().determinerX(graphique, abscisse),
						Outils.getInstance().determinerY(graphique, 0),
						-Outils.getInstance().determinerX(graphique, abscisse)+Outils.getInstance().determinerX(graphique, 0),
						Outils.getInstance().determinerY(graphique, ordonnee)-Outils.getInstance().determinerY(graphique, 0)
				);
			}
		}

		graphique.add(this);
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(options.getCouleur());
		if(abscisse>=0) {
			if(ordonnee>=0){
				g.drawLine(0, getHeight(), getWidth(), 0);
				g.drawLine(getWidth()-1, 1, getWidth()-1, 11);
				g.drawLine(getWidth()-1, 1, getWidth()-10, 1);
			}
			else {
				g.drawLine(0, 0, getWidth(), getHeight());
				g.drawLine(getWidth()-1, getHeight()-1, getWidth()-1, getHeight()-11);
				g.drawLine(getWidth()-1, getHeight()-1, getWidth()-10, getHeight()-1);
			}
		}
		else {
			if(ordonnee>=0){
				g.drawLine(0, 0, getWidth(), getHeight());
				g.drawLine(0, 1, 10, 1);
				g.drawLine(0, 1, 0, 11);
			}
			else {
				g.drawLine(0, getHeight(), getWidth(), 0);
				g.drawLine(0, getHeight()-1, 0, getHeight()-11);
				g.drawLine(0, getHeight()-1, 10, getHeight()-1);
			}
		}
	}

	/**
	 * @return the abscisse
	 */
	public double getAbscisse() {
		return abscisse;
	}

	/**
	 * @return the ordonnee
	 */
	public double getOrdonnee() {
		return ordonnee;
	}

	/**
	 * @return the options
	 */
	public OptionVecteur getOptions() {
		return options;
	}

	/**
	 * @return the nom
	 */
	public char getNom() {
		return nom;
	}




}
