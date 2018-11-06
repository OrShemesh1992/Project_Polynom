package myMath;

import java.util.ArrayList;
import java.util.Iterator;


import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author OrShemesh && YaaraGoldenberg
 *
 */


public class Polynom implements Polynom_able{
	private ArrayList<Monom>  _Polynom;
	/**
	 * This statement on Iterator 
	 */
	public Iterator<Monom> iteretor() 
	{
		return  this._Polynom.iterator();
	}
	/**
	 * This is default constructor 
	 */
	public Polynom ()
	{
		this._Polynom=new ArrayList<Monom>();
	}
	/**
	 * This is copy constructor
	 * @param a
	 */
	public Polynom (Polynom other)
	{	
		this._Polynom = ((Polynom) other.copy())._Polynom;
	}
	/**
	 * This constructor gets string and cut by "+",
	 * and turns it into Polynom 
	 * Example : 2x^2+2^x+-5
	 * @param str
	 */
	public Polynom (String str)
	{	
		Polynom S_ToPolynom=new Polynom();
		String StrLower=str.toLowerCase();
		String plusMin="";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='+'||str.charAt(i)=='-')
			{
				plusMin+=str.charAt(i);
			}
		}
		if(str.charAt(0)!='-') plusMin="+"+plusMin;
		String[] SplitToMonom=StrLower.split("\\+|\\-");
		for (int i = 0; i < SplitToMonom.length; i++) {
			if(plusMin.charAt(i)=='-')
			{
				Monom Temp=new Monom(SplitToMonom[i]);
				Monom Minos=new Monom ("-1");
				Temp.multiply(Minos);
				S_ToPolynom.add(Temp);
			}	
			else
			{
				Monom Temp=new Monom(SplitToMonom[i]);
				S_ToPolynom.add(Temp);
			}
		}
		this._Polynom=((Polynom) S_ToPolynom.copy())._Polynom;
	}
	/**
	 * This constructor gets Polynom from the copy constructor , and do deep copy.
	 */
	public Polynom_able copy() 
	{
		Iterator<Monom> It = this.iteretor();
		Polynom_able Temp = new Polynom();
		while(It.hasNext()) {
			Monom m1 = new Monom(It.next());
			Temp.add(m1);
		}
		return Temp;
	}
	/**
	 *  This function represents a simple function of type y=f(x),
	 *  where both y and x are real numbers.
	 */
	public double f(double x) 
	{
		double sum=0;
		Iterator<Monom> It=this.iteretor();
		while(It.hasNext())
		{
			sum+=It.next().f(x);
		}
		return sum;
	}
	/**
	 * Add Monom to this Polynom
	 * Example : f(x)=x^2+2x g(x)=3x^2---> f(x)+g(x)=4x^2+2x
	 * @param m1 
	 */
	public void add(Monom m1) 
	{
		if(m1.get_coefficient()!=0)
		{
			boolean flag=false;
			Iterator<Monom> It=this.iteretor();
			while (It.hasNext())
			{
				Monom temp=It.next();
				if(temp.get_power()==m1.get_power())
				{
					temp.add(m1);
					flag=true;
				}
			}
			if(flag==false)
				this._Polynom.add(m1);
			Monom_Comperator cmpByPower=new Monom_Comperator();
			this._Polynom.sort(cmpByPower);
		}
	}
	/**
	 * Add Polynom to this Polynom
	 * Example : f(x)=x^2+2x g(x)=8x^3-3x^2+4x---> f(x)+g(x)=8x^3-2x^2+6x
	 * @param p1 
	 */
	public void add(Polynom_able p1) 
	{
		Iterator<Monom> It=p1.iteretor();
		while(It.hasNext())
		{
			this.add(It.next());
		}
	}
	/**
	 * Sub Monom to this Polynom
	 * Example : f(x)=x^2+2x g(x)=3x^2---> f(x)-g(x)=-2x^2+2x
	 * @param m1 
	 */
	public void substract(Monom m1) 
	{
		if(m1.get_coefficient()!=0)
		{
			boolean flag=false;
			Iterator<Monom> It=this.iteretor();
			while (It.hasNext())
			{
				Monom temp=It.next();
				if(temp.get_power()==m1.get_power())
				{
					temp.substract(m1);
					flag=true;
				}
			}
			if(flag==false)
				this._Polynom.add(m1);
			Monom_Comperator cmpByPower=new Monom_Comperator();
			this._Polynom.sort(cmpByPower);
		}
	}
	/**
	 * Sub Polynom to this Polynom
	 * Example : f(x)=x^2+2x g(x)=8x^3-3x^2+4x---> f(x)-g(x)=8x^3+4x^2+6x
	 * @param p1 
	 */
	public void substract(Polynom_able p1) 
	{
		Iterator<Monom> It=p1.iteretor();
		while(It.hasNext())
		{
			this.substract(It.next());
		}
	}
	/**
	 * Multiply Polynom by this Polynom
	 * Example : f(x)=x^2+2x g(x)=3x^2+2 ---> f(x)*g(x)=3.0*x^4+6.0*x^3+2.0*x^2+4.0*x^1
	 * @param p1 
	 */
	public void multiply(Polynom_able p1) 
	{
		Iterator<Monom> It=this.iteretor();
		Polynom temp=new Polynom();
		while(It.hasNext())
		{
			Monom a=It.next();
			Iterator<Monom> ItP1=p1.iteretor();
			while(ItP1.hasNext())
			{
				Monom b=new Monom(a);
				b.multiply(ItP1.next());
				temp.add(b);
			}
		}	
		this._Polynom=((Polynom) temp.copy())._Polynom;
	}
	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 */
	public Polynom_able derivative() {
		Iterator<Monom> It=this._Polynom.iterator();
		while(It.hasNext())
		{
			It.next().derivative();
		}
		return this.copy();
	}
	/**
	 * 	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 * see : https://he.wikipedia.org/wiki/%D7%A9%D7%99%D7%98%D7%AA_%D7%94%D7%97%D7%A6%D7%99%D7%99%D7%94
	 */
	public double root(double x0, double x1, double eps) 
	{
		double x2 = x0; 
		if(x0>x1)
		{
			throw new RuntimeException("ERR: x0 need to be smaller then x1");
		}
		if ((f(x0)) * (f(x1)) >= 0) 
		{ 
			throw new RuntimeException("ERR: The function does not cut the x-axis");
		} 
		else
		{

			while ((x1-x0) >= eps) 
			{  
				x2 = (x0+x1)/2;   
				if (f(x2) == 0.0) 
					break;
				else if ((f(x2)*f(x0)) < 0) 
					x1 = x2; 
				else
					x0 = x2; 
			} 
		}
		return x2;
	}
	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	public double area(double x0, double x1, double eps) 
	{
		double temp;
		double sum = 0.0;
		if(x0>x1) {
			temp=x0;
			x0=x1;
			x1=temp;
		}
		for (Double i=x0;i<x1;i=i+eps)
		{
			if(f(i)>=0)
			{
				sum+=((f(i)+f(i+eps))/2)*eps;	
			}
		}
		return sum;
	}
	/**
	 * This function get Polynom and checking if there equals
	 * example : f(x1)=2x^3+2x == f(x2)=2x^3+2x return true
	 * @param p1
	 * @return true or false
	 */
	public boolean equals(Polynom_able p1) 
	{

		Iterator<Monom> It=this._Polynom.iterator();
		Iterator<Monom> ItP1=p1.iteretor();
		if(It.hasNext()&&ItP1.hasNext())
		{
			while (It.hasNext())
			{
				if(!It.next().equals(ItP1.next()))
				{
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * This function checking if the Polynom is 0
	 * @return true or false
	 */
	public boolean isZero() 
	{
		boolean flag=true;
		Iterator<Monom> It=this.iteretor();

		while(It.hasNext())
		{
			if(It.next().get_coefficient()!=0)
			{
				flag =false;
			}
		}
		return flag;
	}
	/**
	 * This function print the Polynom
	 */
	public String toString()
	{
		String str="[";
		Iterator<Monom> It=this.iteretor();
		while (It.hasNext())
		{
			Monom temp=new Monom (It.next());
			if(It.hasNext()&&temp.get_coefficient()!=0)
			{
				str+=temp.toString()+" + " ;
			}
			else if(!It.hasNext()&&temp.get_coefficient()!=0)
			{
				str+=temp.toString();
			}
			else if(!It.hasNext()&&temp.get_coefficient()==0)
			{
				str=str.substring(0,str.length()-3);
			}
		}
		str+="]";
		return str;
	}
}
