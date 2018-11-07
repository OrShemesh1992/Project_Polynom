import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import myMath.Monom;
import myMath.Polynom;

class testMyProject {
	Monom m , m1 , m2 , m3 , expectedMonom , output;
	Polynom poly;
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
		if(expectedMonom == m) {
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
		if(expectedMonom == m) {
			fail("fail");
		}
	}
	@Test
	void testDerivative() {
		expectedMonom = new Monom(6,2);
		m.derivative();
		if(expectedMonom == m) {
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
			if(expectedMonom == m) {
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
	void testPolynomConstractor() {
	}
	@BeforeEach
	void setUp() throws Exception {
		m = new Monom(2,3);
		m1 = new Monom(2,3);
		m2 = new Monom(4,2);
	}
}
