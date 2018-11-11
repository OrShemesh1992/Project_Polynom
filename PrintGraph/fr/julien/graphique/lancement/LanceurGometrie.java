package fr.julien.graphique.lancement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.julien.graphique.Graphique;
import fr.julien.graphique.ZoneGraphique;
import fr.julien.graphique.axes.AxeX;
import fr.julien.graphique.axes.AxeY;
import fr.julien.graphique.axes.OptionAxe;
import fr.julien.graphique.element.forme.Cercle;
import fr.julien.graphique.element.forme.Polygone;
import fr.julien.graphique.element.point.Point;
import fr.julien.graphique.element.quadrillage.Quadrillage;

public class LanceurGometrie {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(-1, 10, optionsAxes), new AxeY(-1, 10, optionsAxes));
		Graphique.getInstance().ajouterElement(new Quadrillage(1, 1));
		List<Point> points = new ArrayList<Point>();
		points.add(new Point('A', 6, 3));
		Graphique.getInstance().ajouterElement(points.get(0));
		points.add(new Point('B', 4, 6));
		Graphique.getInstance().ajouterElement(points.get(1));
		points.add(new Point('C', 7, 8));
		Graphique.getInstance().ajouterElement(points.get(2));
		Graphique.getInstance().ajouterElement(new Polygone(points));
		Graphique.getInstance().ajouterElement(new Cercle(new Point(2, 2), 3));
		f.add(new ZoneGraphique());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
