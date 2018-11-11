package fr.julien.graphique.element.forme;

import java.awt.Graphics;
import java.util.List;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.point.Point;

public class Polygone extends AbstractForme {

	private static final long serialVersionUID = -1593093300214669353L;
	
	private List<Point> points;
	private int[] xPoints;
	private int[] yPoints;
	
	

	/**
	 * @param points
	 */
	public Polygone(List<Point> points, OptionForme options) {
		super(options);
		this.points = points;
		xPoints = new int[points.size()];
		yPoints = new int[points.size()];
		for(int i=0; i<points.size(); i++){
			xPoints[i]=Outils.getInstance().determinerX(Graphique.getInstance(), points.get(i).getAbscisse());
			yPoints[i]=Outils.getInstance().determinerY(Graphique.getInstance(), points.get(i).getOrdonnee());
		}
		setOpaque(false);
	}
	
	public Polygone(List<Point> points) {
		this(points, OptionForme.getDefault());
	}



	@Override
	public void dessiner(Graphique graphique) {
		setBounds(0, 0, LARGEUR, HAUTEUR);
		graphique.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(getOptions().getCouleur());
		if(getOptions().isPlein()){
			g.fillPolygon(xPoints, yPoints, points.size());
		}
		else {
			g.drawPolygon(xPoints, yPoints, points.size());
			
		}
	}

}
