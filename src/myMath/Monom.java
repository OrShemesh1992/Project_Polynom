
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author OrShemesh && YaaraGoldenberg;

 */
public class Monom implements function{
	private double _coefficient; 
	private int _power;
	/**
	 * This Monom constructor gets 2 variables 
	 * the first is Double for the coefficient and the second Integer is for the power
	 * @author OrShemesh && YaaraGoldenberg;
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
		if(b<0)
		{
			throw new RuntimeException("ERR: The power can't be negative number");
		}
	}
	/**
	 * This is copy constructor of Monom.
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	/**
	 * function set coefficient.
	 *  @param p
	 */
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	/**
	 * function set power.
	 * @param p
	 */
	private void set_power(int p) {
		this._power = p;
	}	
	/**
	 * function get coefficient.
	 * @return coefficient.
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/**
	 * function get power.
	 * @return power.
	 */
	public int get_power() {
		return this._power;
	}
	/**
	 *  This function represents a simple function of type y=f(x),
	 *  where both y and x are real numbers.
	 */
	public double f(double x) {
		return (this._coefficient)*(Math.pow((x), _power));
	}
	/**
	 * This function get Monom and if the power of the Monom is equal to 
	 * the power the second Monom it's (+)add them.
	 * example :2x^2+3x^2=5x^2
	 * @param m
	 */
	public void add(Monom m)
	{
		if(this._power==m.get_power())
			this._coefficient+=m.get_coefficient();	
		else
			throw new RuntimeException("ERR: The power is not the same ");

	}
	/**
	 * This function get Monom and if the power of the Monom is equal to 
	 * the power the second Monom it's (-)sub them.
	 * example :2x^2-3x^2=-1x^2
	 * @param m
	 */
	public void substract(Monom m)
	{
		if(this._power==m.get_power())
			this._coefficient-=m.get_coefficient();	
		else
			throw new RuntimeException("ERR: The power is not the same ");	
	}
	/**
	 * This function get Monom and multiply the coefficient and add power
	 * example :2x^2*3x^2=6x^4
	 * @param m
	 */
	public void multiply(Monom m1)
	{
		this._coefficient*=m1.get_coefficient();
		this._power+=m1.get_power();
	}
	/**
	 * This function get Monom and checking if there equals
	 * example : f(x1)=2x^3 != f(x2)=6x^2 return false
	 * @param m
	 * @return true or false
	 */
	public boolean equals(Monom m)
	{
		return (m.get_coefficient()==this._coefficient&&m._power==this._power);
	}
	/**
	 * This function is calculation the derivative of this Monom
	 * example :f(x)=2x^3--->f(x)'=6x^2
	 */
	public void derivative ()
	{
		if(this._power==0)
		{
			this._coefficient=0;
		}
		else 
		{
			this._coefficient*=this._power;
			this._power-=1;
		}
	}
	/**
	 * This function print the Monom
	 */
	public String toString()
	{
		String s="";
		if(this._coefficient==0)
		{
			s+="0";	
		}
		else if(this._power==0)
		{
			s+=Double.toString(this._coefficient);
		}
		else
		{
			s+=Double.toString(this._coefficient)+"*x^"+Integer.toString(this._power);
		}
		return s;
	}
/**
 * This constructor gets String and turns it into Monom
 * Example : 2x^2 , x , -5 , x^2 , 6*x ...
 * @param str
 */
	public Monom (String str)
	{
		if(str==null)throw new RuntimeException("ERR: The String is null");
		double a=0;
		int b=0;
		String StrLower=str.toLowerCase();//X---->x
		int index_pi=StrLower.indexOf("*");// if i have a *
		int index_x=StrLower.indexOf("x");/// if i have a x
		int index_pow =StrLower.indexOf("^");// if i have a ^


		if(index_x<0)//i do not have x
		{
			a=Double.parseDouble(StrLower);
		}
		else //i have x
		{
			if(index_pi<0)//if i do not have * 
			{
				if(StrLower.substring(0, index_x).equals(""))
					a=1;
				else if(StrLower.substring(0, index_x).equals("-"))
					a=-1;
				else
					a=Double.parseDouble(StrLower.substring(0, index_x));
			}
			else//if i have *
			{
				if(StrLower.substring(0, index_x).equals(""))
					a=1;
				else
					a=Double.parseDouble(StrLower.substring(0, index_pi));
			}

			if(index_pow<0) {//if i don't have ^
				String StrPow=StrLower.substring(index_x+1);
				StrPow="1"+StrPow;
				b=Integer.parseInt(StrPow);
				if(b!=1)
				{
					throw new RuntimeException("ERR: you can't write without power '^' ");
				}
			}else {//if i  have ^
				if(StrLower.substring(index_pow+1,index_pow+2).equals("-")||StrLower.substring(index_pow+1,index_pow+2).equals(""))
				{
					throw new RuntimeException("ERR: The power can't be negative number or you did'nt write power for x");
				}
				else if(StrLower.substring(index_x+1,index_x+2).equals(""))
				{
					b=1;
				}
				else
				{
					b=Integer.parseInt(StrLower.substring(index_pow+1));
				}
			}
		}
		this._coefficient=a;
		this._power=b;
	}


}
