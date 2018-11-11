package fr.julien.graphique.element.point;

import java.awt.Font;
import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.AbstractElementGraphique;

public class Point extends AbstractElementGraphique {

	private static final long serialVersionUID = 1306671540295022717L;
	private final Font font = new Font("Arial", Font.PLAIN, 16);


	private char nom;
	private double x;
	private double y;
	private OptionPoint options;

	public Point(char nom, double x, double y, OptionPoint options){
		this.nom=nom;
		this.x=x;
		this.y=y;
		this.options=options;
	}

	public Point(char nom, double x, double y){
		this(nom, x, y, OptionPoint.getDefault());
	}
	
	public Point(double x, double y){
		this('A', x, y, OptionPoint.getDefault());
	}

	public double getAbscisse() { 
		return x;
	}

	public double getOrdonnee() { 
		return y;
	}

	/**
	 * @return the nom
	 */
	public char getNom() {
		return nom;
	}

	@Override
	public void dessiner(Graphique graphique) {
		if(Outils.getInstance().isDansFenetre(graphique, x, y)){
			setBounds(
					Outils.getInstance().determinerX(graphique, x)-8,
					Outils.getInstance().determinerY(graphique, y)-24,
					32,
					32
			);
			graphique.add(this);
		}


	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(options.getCouleur());
		g.drawLine(0, 24, 16, 24);
		g.drawLine(8, 16, 8, 32);
		if(options.isAfficherNom()){
			g.setFont(font);
			g.drawString(nom+"", 16, 16);
		}
	}


}