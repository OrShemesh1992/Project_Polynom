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
/**
 * we take julien function and, because his print function that gets string 
 * is not the same like ours. we crate a new function that adjust our string
 * to be like his.
 * "0.2x^4-1.5x^3+3.0x^2-x-5"----> "0.2*X^4+(0-1.5)*X^3+3.0*X^2+(0-1.0)*X^1+(0-5.0)"
 */
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
	/**
	 * In this function we find the max point and the min point,
	 * and save all of them in array list 
	 * by using julien point class.
	 */
	public static ArrayList<Point> foundMinMax(Polynom p,double x2,double x3,double eps) {
		double x0=x2;
		double x1=x3;
		ArrayList<Point>  points=new ArrayList<Point>(); ;
		Polynom p1=new Polynom(p);
		p1.derivative();
		for (double i = x0; i < x1; i+=eps) {
			if(p1.f(i)<0&& p1.f(i+eps) > 0)
			{
				points.add(new Point(i,p.f(i)));
			}
			if(p1.f(i) > 0 && p1.f(i+eps) < 0) {
				points.add(new Point(i,p.f(i)));
			}
		}
		return points;
	}
	/**
	 * Here we use Julien function to print the graph, and we marked
	 * in the graph the maximum and minimum points.
	 * we use Changesyntax and foundMinMax function to adjust the graph to ours printing.
	 */
	public static void print(Polynom p, double x0, double x1) {
		String s=Changesyntax(p);
		ArrayList<Point>  MaxMin=foundMinMax(p,x0,x1,0.01);
		Iterator<Point> It = MaxMin.iterator();
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OptionAxe optionsAxes = new OptionAxe(Color.BLACK, true, -1, 1, true, true);
		Graphique.getInstance().initGraphique(new AxeX(x0, 10, optionsAxes), new AxeY(-10, x1, optionsAxes));
		char a = 'A';
		while(It.hasNext())
		{
			Point b= (It.next());
			Graphique.getInstance().ajouterElement(new Point(a, b.getAbscisse(), b.getOrdonnee()));
			a++;
		}
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
