package myMath;

public class testPrint {

	public static void main(String[] args) {

		Polynom poly = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		PrintPolynom a=new PrintPolynom();
		a.print(a.Changesyntax(poly), -2, 6);

	}
}
