package fr.julien.graphique.axes;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.IElementGraphique;

public class AxeX extends AbstractAxe implements IElementGraphique {

	private static final long serialVersionUID = 3468189240058271782L;

	/**
	 * @param min
	 * @param max
	 * @param pas
	 */
	public AxeX(double min, double max) {
		super(min, max);
	}

	/**
	 * @param min
	 * @param max
	 * @param options
	 */
	public AxeX(double min, double max, OptionAxe options) {
		super(min, max, options);
	}

	public void dessiner(Graphique graphique) {
		setBounds(0, Outils.getInstance().determinerY(graphique, 0)-5, LARGEUR, 30);
		graphique.add(this);

	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getOptions().getCouleur());
		g.drawLine(0, 5, getWidth(), 5);
		if(getOptions().isAfficherGraduations()){
			for(int i=(int)getMin(); i<getMax(); i++){
				int pos=Outils.getInstance().determinerX(Graphique.getInstance(), i);
				g.drawLine(pos, 0, pos, 10);
				if(getOptions().isAfficherValeurs() && i!=0){
					g.drawString(i+"", pos-2, 22);
				}
			}
		}
		if(getOptions().isAfficherOrientation()){
			g.drawLine(LARGEUR, 5, LARGEUR-15, 0);
			g.drawLine(LARGEUR, 5, LARGEUR-15, 10);
		}
	}

}
