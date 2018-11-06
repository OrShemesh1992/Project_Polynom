package myMath;

import java.util.Comparator;
/**
 * This class comperator of Monom by Power.
 * Example: 7x^2 + 4x^1 + 8x^0
 * @author OrShemesh && YaaraGoldenberg;
 */
public class Monom_Comperator implements Comparator<Monom> {
	public int compare(Monom a, Monom b) {
		return b.get_power()-a.get_power();
	}
}
