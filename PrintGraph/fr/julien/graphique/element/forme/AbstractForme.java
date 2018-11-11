package fr.julien.graphique.element.forme;

import fr.julien.graphique.element.AbstractElementGraphique;



public abstract class AbstractForme extends AbstractElementGraphique {
	
	private static final long serialVersionUID = 2451755585766612884L;
	
	private OptionForme options;
	
	public AbstractForme(OptionForme options) {
		this.options = options;
	}
	
	public AbstractForme(){
		this(OptionForme.getDefault());
	}

	public OptionForme getOptions() {
		return options;
	}
	
}
