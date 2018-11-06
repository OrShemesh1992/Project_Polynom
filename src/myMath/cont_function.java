package myMath;

/**
 * The interface represents a continuance function 
 * @author Boaz
 *
 */ 
public interface cont_function extends function{
	/**
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting pooint
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 */
	public double area(double x0, double x1, double eps);
}
