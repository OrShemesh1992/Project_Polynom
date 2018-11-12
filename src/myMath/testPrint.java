package myMath;
public class testPrint {
	/**
	 * testing the graph printing.
	 */
	public static void main(String[] args) {
		Polynom poly = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		PrintPolynom a=new PrintPolynom();
		System.out.println(poly.areaNegative(-2, 6, 0.01));
		a.print(poly, -2, 6);
		
	}
}
