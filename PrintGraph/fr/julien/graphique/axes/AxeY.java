package fr.julien.graphique.axes;

import java.awt.Graphics;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.element.IElementGraphique;

public class AxeY extends AbstractAxe implements IElementGraphique {

	private static final long serialVersionUID = 1L;

	/**
	 * @param min
	 * @param max
	 * @param pas
	 */
	public AxeY(double min, double max) {
		super(min, max);
	}

	/**
	 * @param min
	 * @param max
	 * @param options
	 */
	public AxeY(double min, double max, OptionAxe options) {
		super(min, max, options);
	}

	public void dessiner(Graphique graphique) {
		setBounds(Outils.getInstance().determinerX(graphique, 0)-15, 0, 20, HAUTEUR);
		graphique.add(this);
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getOptions().getCouleur());
		g.drawLine(15, 0, 15, HAUTEUR);
		if(getOptions().isAfficherGraduations()){
			for(int i=(int)getMin(); i<getMax(); i++){
				int pos=Outils.getInstance().determinerY(Graphique.getInstance(), i);
				g.drawLine(10, pos, 20, pos);
				if(getOptions().isAfficherValeurs()){
					if(i!=0){
						g.drawString(i+"", 0, pos+3);
					}
					else {
						g.drawString(i+"", 5, pos+15);
					}
				}
			}
		}
		if(getOptions().isAfficherOrientation()){
			g.drawLine(15, 0, 10, 15);
			g.drawLine(15, 0, 20, 15);
		}
	}


}
