import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import myMath.Monom;
import myMath.Polynom;

class testMyProject {
	Monom m , m1 , m2 , m3 , expectedMonom;
	Polynom poly , poly1 , poly2 , poly3 , poly4 , poly5 , expectedPolynom;
	@Test
	void testConstractor(){
		try {
			m = new Monom (1,-1);
			Assert.fail();
		}
		catch(RuntimeException e) {}
	}
	@Test
	void testf_x(){
		double output = m.f(2);
		if(output != 16) {
			fail("fail");
		}
	}
	@Test
	void testAdd() {
		expectedMonom = new Monom(4,3);
		m.add(m);
		if(!expectedMonom.equals(m) ) {
			fail("The power is not the same");
		}
		try {
			m =new Monom (1,1);
			m1.add(m);
			Assert.fail();
		}
		catch(RuntimeException e) {}
	}
	@Test
	void testMultiply() {
		expectedMonom = new Monom(8,5);
		m.multiply(m2);
		if(!expectedMonom.equals(m)) {
			fail("fail");
		}
	}
	@Test
	void testDerivative() {
		expectedMonom = new Monom(6,2);
		m.derivative();
		if(!expectedMonom.equals(m)) {
			fail("fail");
		}
	}
	@Test
	void testEqual() {
		boolean output = m.equals(m1);
		assertEquals(true , output);
	}
	@Test
	void testStringConstractor()
	{
		String s = "0,-6.0,6.0,6.0,1.0*x^1,6.0*x^1,6.0*x^1,6.0*x^2,66.0*x^2,1.0*x^2";
		String[] Split = s.split(",");
		for (int i = 0; i < Split.length; i++) {
			m = new Monom (Split[i]);
			expectedMonom = new Monom (m.get_coefficient(),m.get_power());
			if(!expectedMonom.equals(m)) {
				fail("fail");
			}
		}
		String str = "2x^,3x^-3,xx";
		String[] splited = str.split(",");
		for (int i = 0; i < splited.length; i++) {
			try {
				m = new Monom(splited[i]);
				Assert.fail();
			}
			catch(RuntimeException e) {}
		}
	}
	@Test
	void testCopyPolynom() {
		expectedPolynom = new Polynom ("5x^3+9x^2-21");
		poly.copy();
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testfF_x() {
		double output = poly.f(2);
		if(output != 55) {
			fail("fail");
		}
	}
	@Test
	void testAddMonom() {
		expectedPolynom = new Polynom("5x^3+13x^2-21");
		poly.add(m2);
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testAddPolynom() {
		expectedPolynom = new Polynom("7x^3+2x^2-5x-21");
		poly.add(poly1);
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testSubtractPolynom() {
		expectedPolynom = new Polynom("3x^3+16x^2+5x-21");
		poly.substract(poly1);
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testMultiplyPolynom() {
		expectedPolynom = new Polynom("10x^6-17x^5-88x^4-87x^3+147x^2+105x");
		poly.multiply(poly1);
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testPolynomDerivative() {
		expectedPolynom = new Polynom("15x^2+18x");
		poly.derivative();
		if(!expectedPolynom.equals(poly)) {
			fail("fail");
		}
	}
	@Test
	void testRoot() {
		double output = 0.24626636505126953;
		if(output != poly2.root(-2, 2, 0.000001)) {
			fail("fail");
		}
	}
	@Test
	void testArea() {
		double output = 2.0000000000000044;
		if(output != poly3.area(-2, 2, 0.01)) {
			fail("fail");
		}
	}
	@Test
	void testEqualsPolynom() {
		boolean output = poly1.equals(poly4);
		assertEquals(true , output);
	}
	@Test
	void testIsZero() {
		boolean output = poly5.isZero();
		assertEquals(true , output);
	}
	@BeforeEach
	void setUp() throws Exception {
		m = new Monom(2,3);
		m1 = new Monom(2,3);
		m2 = new Monom(4,2);
		poly = new Polynom("5x^3+9x^2-21");
		poly1 = new Polynom("2x^3-7x^2-5x");
		poly2 = new Polynom("x^3+4x-1");
		poly3 = new Polynom("x");
		poly4 = new Polynom("2x^3-7x^2-5x");
		poly5 = new Polynom("0+0x^0+0.0+0x^2+0*x");
	}
}



