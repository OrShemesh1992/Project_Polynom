package myMath;

public class testMonom {

	public static void main(String[] args) {
		/**
		 * testing monom constructor
		 */
		Monom a1 = new Monom(-2.8 , 1);
		System.out.println("Monom constructor: " + a1); 
		/**
		 * testing copy constructor
		 */
		Monom a2 = new Monom(a1);
		System.out.println("\ncopy constructor: " + a2); 
		/**
		 * testing get coefficient function and get power function
		 */
		System.out.println("\ncoefficient: " + a1.get_coefficient() + ", power: " + a2.get_power() );
		/**
		 * testing f(x) function
		 */
		System.out.println("\nCheaking f(5) = " + a1.f(5));
		/**
		 * testing for adding Monom to other Monom
		 */
		a1.add(a2);
		System.out.println("\nadd 2 monoms:\nf(x)= -2.3x  , g(x)= -2.3x \nf(x)+g(x)= " + a1 );
		/**
		 * testing for substract Monom to other Monom
		 */
		Monom a3=new Monom (5,3);
		Monom a4=new Monom (4,3);
		a3.substract(a4);
		System.out.println("\nsubstract 2 monoms:\nf(x)= 5x^3 , g(x)= 4x^3 \nf(x)-g(x)= " + a3);
		/**
		 * test to multiply Monom by other Monom
		 */
		Monom a18 = new Monom(3 , 3);
		a18.multiply(a4);
		
		System.out.println("\nmultiply 2 monoms:\nf(x)= 3x^3 , g(x)= 4x^3\nf(x)*g(x) = "+ a18);
		/**
		 * test to equals Monoms
		 */
		Monom a5=new Monom (4,3);
		Monom a6=new Monom (4,3);
		Monom a7=new Monom (4,2);
		System.out.println("\nequals:\n4x^3 == 4x^3 ? : " +a5.equals(a6));
		System.out.println("4x^3 == 4x^2 ? : " +a5.equals(a7));
		/**
		 * test to derivative
		 */
		a5.derivative();
		System.out.println("\nderivative:\nf(4x^3)' = "+ a5);
		/**
		 * test constructor gets String and turns it into Monom
		 */
		Monom a8=new Monom ("0");
		Monom a9=new Monom ("-6");
		Monom a10=new Monom ("6");
		Monom a11=new Monom ("6x^0");
		Monom a12=new Monom ("x");
		Monom a13=new Monom ("6x");
		Monom a14=new Monom ("6*x");
		Monom a15=new Monom ("6*x^2");
		Monom a16=new Monom ("66x^2");
		Monom a17=new Monom ("x^2");
		
		System.out.println("\nAll the option to get String and return Monom\n");
		System.out.print(a8+" , ");
		System.out.print(a9+" , ");
		System.out.print(a10+" , ");
		System.out.print(a11+" , ");
		System.out.print(a12+" , ");
		System.out.print(a13+" , ");
		System.out.print(a14+" , ");
		System.out.print(a15+" , ");
		System.out.print(a16+" , ");
		System.out.print(a17);
		

	}
}



