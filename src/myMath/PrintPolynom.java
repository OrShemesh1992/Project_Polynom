package myMath;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
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

public class PrintPolynom {
	public Polynom  _Polynom;
	
	public static String Changesyntax(Polynom Poly)
	{
		Iterator<Monom> It =Poly.iteretor();
		String s="";


		while(It.hasNext())
		{
			Monom a=new Monom(It.next());
			if(a.get_coefficient()==0)
			{
				s+="0";
			}
			else if(a.get_power()==0)
			{
				if(a.get_coefficient()>0)
				{
					s+="+"+Double.toString(a.get_coefficient());
				}else {
					s+="+(0"+Double.toString(a.get_coefficient())+")";
				}
			}
			else
			{

				if(a.get_coefficient()>0)
				{
					s+="+"+Double.toString(a.get_coefficient())+"*X^"+Integer.toString(a.get_power());
				}else {
					s+="+(0"+Double.toString(a.get_coefficient())+")"+"*X^"+Integer.toString(a.get_power());
				}
			}
		}
		if(s.charAt(0)=='+')
		{
			s=s.substring(1, s.length());
		}
		return s;
	}
	public static void print(String s, double x0, double x1) {

		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(x0, 10, optionsAxes), new AxeY(-10, x1, optionsAxes));
		Graphique.getInstance().ajouterElement(new Point('A', 0, 0));
		Graphique.getInstance().ajouterElement(new Fonction(s)); 
		List<Point> points = new ArrayList<Point>(); 
		Graphique.getInstance().ajouterElement(new Polygone(points));
		Graphique.getInstance().ajouterElement(new Quadrillage(0.5, 0.5));
		f.add(new ZoneGraphique());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
