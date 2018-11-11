package fr.julien.graphique.axes;

import fr.julien.graphique.element.AbstractElementGraphique;
import fr.julien.graphique.element.IElementGraphique;


public abstract class AbstractAxe extends AbstractElementGraphique implements IElementGraphique {

	private static final long serialVersionUID = -3346505468574877099L;
	private double min;
	private double max;
	private OptionAxe options;
	
	public AbstractAxe(double min, double max, OptionAxe options){
		this.min=min;
		this.max=max;
		this.options=options;
	}
	
	public AbstractAxe(double min, double max){
		this(min, max, OptionAxe.getDafault());
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	/**
	 * @return the options
	 */
	public OptionAxe getOptions() {
		return options;
	}

	
	
}
