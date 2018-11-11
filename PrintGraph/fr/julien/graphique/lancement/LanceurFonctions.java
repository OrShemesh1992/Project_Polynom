package fr.julien.graphique.lancement;

import java.awt.Color;

import javax.swing.JFrame;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.ZoneGraphique;
import fr.julien.graphique.axes.AxeX;
import fr.julien.graphique.axes.AxeY;
import fr.julien.graphique.axes.OptionAxe;
import fr.julien.graphique.element.fonction.Fonction;
import fr.julien.graphique.element.fonction.OptionFonction;

public class LanceurFonctions {

	public static void main(String[] args) {
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(-5, 5, optionsAxes), new AxeY(-5, 5, optionsAxes));
		Graphique.getInstance().ajouterElement(new Fonction("exp(X)-2", new OptionFonction(Color.RED)));
		Graphique.getInstance().ajouterElement(new Fonction("0.5*X+1", new OptionFonction(Color.BLACK)));
		Graphique.getInstance().ajouterElement(new Fonction("0-X^2", new OptionFonction(Color.BLUE)));
		f.add(new ZoneGraphique());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
