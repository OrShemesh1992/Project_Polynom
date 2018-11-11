package fr.julien.graphique.element.segment;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.AbstractElementGraphique;
import fr.julien.graphique.element.point.Point;

public class Segment extends AbstractElementGraphique {

	private static final long serialVersionUID = -5183915920938929881L;
	
	private Point point1;
	private Point point2;
	private OptionSegment options;

	/**
	 * @param point1
	 * @param point2
	 * @param options
	 */
	public Segment(Point point1, Point point2, OptionSegment options) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.options = options;
	}

	/**
	 * @param point1
	 * @param point2
	 */
	public Segment(Point point1, Point point2) {
		this(point1, point2, OptionSegment.getDefault());
	}


	@Override
	public void dessiner(Graphique graphique) {
		setBounds(0, 0, LARGEUR, HAUTEUR);
		graphique.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(options.getCouleur());
		g.drawLine(
				Outils.getInstance().determinerX(Graphique.getInstance(), point1.getAbscisse()),
				Outils.getInstance().determinerY(Graphique.getInstance(), point1.getOrdonnee()),
				Outils.getInstance().determinerX(Graphique.getInstance(), point2.getAbscisse()),
				Outils.getInstance().determinerY(Graphique.getInstance(), point2.getOrdonnee())
		);
	}

}
