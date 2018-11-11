package myMath;

public class testPolynom {

	public static void main(String[] args) {

		Polynom p = new Polynom();
		Monom m1 = new Monom(-2 , 1);
		Monom m2 = new Monom(5 , 3);
		Monom m3 = new Monom(6 , 2);
		Monom m4 = new Monom(-3 , 0);
		Monom m5 = new Monom(3 , 0);
		Polynom m6 = new Polynom("5x^3");
		p.add(m1);
		p.add(m2);
		p.add(m3);
		p.add(m4);
		Polynom p3 = new Polynom();
		p3.add(m1);
		p3.add(m2);
		p3.add(m5);
		/**
		 * testing copy constructor
		 */
		Polynom p1 = new Polynom(p);
		System.out.println("copy constructor: " + p1); 
		/**
		 * testing constructor gets String and turns it into Polynom
		 */
		Polynom p2 = new Polynom("3x^3+4x^2+6x+9x-4x^3+6x^7+0.0");
		System.out.println("\nstring polynom to monoms polynom: " + p2);
		/**
		 * test for f(x)
		 */
		System.out.println("\nCheaking f(1) = " + p1.f(1));
		/**
		 * testing for adding Monom to Polynom
		 */
		p1.add(m3);
		System.out.println("\nadd Monom : \nf(x)= 5.0*x^3 + 6.0*x^2 - 2.0*x^1 - 3.0" + "\ng(x)= 6x^2" + "\nf(x)+g(x) = " + p1);
		/**
		 * testing for adding 2 polynomials
		 */
		p1.add(p3);
		System.out.println("\nadd polynom : \nf(x)= 5x^3 + 12x^2 - 2x - 3" + "\ng(x)= 5x^3 - 2x + 3" + "\nf(x)+g(x)= " + p1);
		/**
		 * testing for substract Monom to polynom
		 */
		p3.substract(m6);
		System.out.println("\nsub Monom : \nf(x)= 5x^3 - 2x + 3" + "\ng(x)= 5x^3" + "\nf(x)-g(x)= " + p3 );
		/**
		 * testing for substract 2 polynomials
		 */
		Polynom p4 = new Polynom("5x^2+8X+6");
		Polynom p5 = new Polynom("2x^2+3X+3");
		p4.substract(p5);
		System.out.println("\nsub Polynom : \nf(x)= 5x^2 + 8x + 6" + "\ng(x)= 2x^2 + 3x + 3" + "\nf(x)-g(x) = " + p4);
		/**
		 * testing for Multiply Polynom by other Polynom
		 */
		Polynom p6 = new Polynom("2x^3+1x^1+1");
		Polynom p7 = new Polynom("3x^2+3x^1+3");
		p6.multiply(p7);
		System.out.println("\nMultiply Polynom : \nf(x)= 2x^3 + 1x^1 + 1" + "\ng(x)= 3x^2 + 3x^1 + 3" + "\nf(x)*g(x)= " + p6);
		/**
		 * test for derivative function
		 */
		Polynom p8 = new Polynom("2x^3+4x^2+5x^1+9");
		p8.derivative();
		System.out.println("\nderivative : \nf(2x^3 + 4x^2 + 5x^1 + 9)'= " + p8);
		/**
		 * testing area function
		 */
		Polynom p9 = new Polynom("x");
		System.out.println("\nCheaking Positive area between -2 to 2 f(x) = x\n" + p9.area(-2, 2, 0.01));
		/**
		 * testing root function
		 */
		Polynom p10= new Polynom ("x^3+4x-1");
		System.out.println("\nThe root 0=x^3+4x-1 between -2 to 2 is :\n"+p10.root(-2, 2, 0.000001));
		/**
		 * testing equals between 2 polynomials
		 */
		Polynom p11 = new Polynom("4x^4+8x^1+88+0");
		Polynom p12 = new Polynom("4x^4+8x^1+88");
		Polynom p13 = new Polynom("9x^4+8x^1-88");
		System.out.println("\nequals :\n4x^4+8x^1+88+0 == 4x^4+8x^1+88 ? " + p11.equals(p12));
		System.out.println("4x^4+8x^1+88 == 9x^4+8x^1-88 ? " + p11.equals(p13));
		/**
		 * testing if the Polynom is zero
		 */
		System.out.println("\nCheacking for zero function:");
		Polynom p14 = new Polynom("0+0x^0+0.0+0x^2+0*x");
		Polynom p15 = new Polynom("0+0x^0+0.0+0x^2+2*x");
		System.out.println("f(x)= 0+0x^0+0.0+0x^2+0x is zero function? " + p14.isZero());
		System.out.println("f(x)= 0+0x^0+0.0+0x^2+2x is zero function? " + p15.isZero());
	}
}
