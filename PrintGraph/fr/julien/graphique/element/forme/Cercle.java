package fr.julien.graphique.element.forme;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.point.Point;

public class Cercle extends AbstractForme {
	
	private Point centre;
	private double rayon;
	

	public Cercle(Point centre, double rayon, OptionForme options) {
		super(options);
		this.centre=centre;
		this.rayon=rayon;
	}
	
	public Cercle(Point centre, double rayon){
		this(centre, rayon, OptionForme.getDefault());
	}

	private static final long serialVersionUID = -991663766847914675L;
	
	

	@Override
	public void dessiner(Graphique graphique) {
		int rayonConverti=Outils.getInstance().determinerX(graphique, rayon);
		setBounds(Outils.getInstance().determinerX(graphique, centre.getAbscisse())-(int)(rayonConverti/2), Outils.getInstance().determinerY(graphique, centre.getOrdonnee())-(int)(rayonConverti/2), rayonConverti, rayonConverti);
		graphique.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(getOptions().getCouleur());
		if(getOptions().isPlein()){
			g.fillOval(0, 0, getWidth(), getHeight());
		}
		else{
			g.drawOval(0, 0, getWidth(), getHeight());
		}
	}

}
