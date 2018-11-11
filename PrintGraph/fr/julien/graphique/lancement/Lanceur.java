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
import fr.julien.graphique.element.fonction.Fonction;
import fr.julien.graphique.element.forme.Polygone;
import fr.julien.graphique.element.point.Point;
import fr.julien.graphique.element.quadrillage.Quadrillage;
import fr.julien.graphique.element.segment.Segment;

public class Lanceur {

	public static void main(String[] args) {
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(-2, 5, optionsAxes), new AxeY(-6, 6, optionsAxes));
		Graphique.getInstance().ajouterElement(new Point('A', 0, 0)); // זה הפקודה להוסיף נקודה
		Graphique.getInstance().ajouterElement(new Fonction("X^2")); // פה אתה שם את הפונקציה שאתה רוצה לצייר
		List<Point> points = new ArrayList<Point>(); // כמו שאמרתי יש לו את מחלקת פוניט אז כשאתה תעשה פונקציה שמציירת נקודות אז אתה יכול פשוט לעשות לולאה ולהדפיס.
		Graphique.getInstance().ajouterElement(new Polygone(points));
		Graphique.getInstance().ajouterElement(new Quadrillage(0.5, 0.5));
		f.add(new ZoneGraphique());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
