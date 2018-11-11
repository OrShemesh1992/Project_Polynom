package fr.julien.graphique.element.quadrillage;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.axes.AbstractAxe;
import fr.julien.graphique.element.AbstractElementGraphique;

public class Quadrillage extends AbstractElementGraphique {
	
	private static final long serialVersionUID = 7927160812608253274L;
	
	private OptionQuadrillage options;
	private double pasHorizontal;
	private double pasVertical;
	
	/**
	 * @param options
	 * @param pasHorizontal
	 * @param pasVertical
	 */
	public Quadrillage(double pasHorizontal, double pasVertical, OptionQuadrillage options) {
		this.options = options;
		this.pasHorizontal = pasHorizontal;
		this.pasVertical = pasVertical;
	}
	
	/**
	 * @param pasHorizontal
	 * @param pasVertical
	 */
	public Quadrillage(double pasHorizontal, double pasVertical) {
		this(pasHorizontal, pasVertical, OptionQuadrillage.getDefault());
	}
	
	@Override
	public void dessiner(Graphique graphique) {
		setBounds(0, 0, LARGEUR, HAUTEUR);
		graphique.add(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(options.getCouleur());
		AbstractAxe axeX = Graphique.getInstance().getAxeX();
		AbstractAxe axeY = Graphique.getInstance().getAxeY();
		for(double i=axeX.getMin(); i<axeX.getMax(); i+=pasHorizontal){
			int x0 = Outils.getInstance().determinerX(Graphique.getInstance(), i);
			g.drawLine(x0, 0, x0, getHeight());
		}
		for(double i=axeY.getMin(); i<axeY.getMax(); i+=pasVertical){
			int y0 = Outils.getInstance().determinerY(Graphique.getInstance(), i);
			g.drawLine(0, y0, getWidth(), y0);
		}
	}
	

}
