package fr.julien.graphique.element.fonction;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.Outils;
import fr.julien.graphique.axes.AbstractAxe;
import fr.julien.graphique.element.AbstractElementGraphique;
import fr.julien.parseurmath.exception.ParsingException;
import fr.julien.parseurmath.metier.ParseurMath;

public class Fonction extends AbstractElementGraphique {


	private static final long serialVersionUID = 3478342277254347829L;

	private String formule;
	private OptionFonction options;
	private List<Integer> positionsX;
	private List<Integer> positionsY;

	/**
	 * @param formule
	 * @param options
	 */
	public Fonction(String formule, OptionFonction options) {
		this.formule = formule;
		this.options = options;
		positionsX = new ArrayList<Integer>(2000);
		positionsY = new ArrayList<Integer>(2000);
		setOpaque(false);
		initValues();
	}

	private void initValues(){
		AbstractAxe axeX = Graphique.getInstance().getAxeX();
		double debut=axeX.getMin();
		double pas=0.01;
		double fin=axeX.getMax();
		for(double k=debut; k<fin; k+=pas){
			double i=(double)(Math.round(100*k))/100;
			String expression = formule.replaceAll("X", "(0"+i+")");
			try {
				double res = ParseurMath.getInstance().parseDouble(expression.replaceAll("\\s", ""));
				positionsX.add(Outils.getInstance().determinerX(Graphique.getInstance(), i));
				positionsY.add(Outils.getInstance().determinerY(Graphique.getInstance(), res));
			} 
			catch (ParsingException e) {
				e.printStackTrace();
			}
		}
	}

	public Fonction(String formule) {
		this(formule, OptionFonction.getDefault());
	}

	@Override
	public void dessiner(Graphique graphique) {
		setBounds(0, 0, LARGEUR, HAUTEUR);
		graphique.add(this);
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(options.getCouleur());
		for(int i=0; i<positionsX.size()-1; i++){
			if(positionsX.get(i+1)<LARGEUR && positionsY.get(i+1)<HAUTEUR){
				g.drawLine(positionsX.get(i), positionsY.get(i), positionsX.get(i+1), positionsY.get(i+1));
			}
		}
	}

}
