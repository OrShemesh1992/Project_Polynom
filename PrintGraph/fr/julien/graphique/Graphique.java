package fr.julien.graphique;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.julien.graphique.axes.AbstractAxe;
import fr.julien.graphique.axes.AxeX;
import fr.julien.graphique.axes.AxeY;
import fr.julien.graphique.element.IElementGraphique;

public class Graphique extends JPanel implements GraphiqueConstants {
	

	private static final long serialVersionUID = 5837475618706996094L;

	private static final Graphique instance = new Graphique();

	private List<IElementGraphique> elements;
	private AbstractAxe axeX;
	private AbstractAxe axeY;
	
	private Graphique(){
		super();
	}
	
	public void initGraphique(AxeX axeX, AxeY axeY){
		setBackground(Color.WHITE);
		this.axeX=axeX;
		this.axeY=axeY;
		elements = new ArrayList<IElementGraphique>();
		build();
		
	}
	
	private void build(){
		setLayout(null);
		axeX.dessiner(this);
		axeY.dessiner(this);
		for(IElementGraphique element : elements){
			element.dessiner(this);
		}
	}

	/**
	 * @return the instance
	 */
	public static Graphique getInstance() {
		return instance;
	}

	/**
	 * @return the axeX
	 */
	public AbstractAxe getAxeX() {
		return axeX;
	}

	/**
	 * @return the axeY
	 */
	public AbstractAxe getAxeY() {
		return axeY;
	}

	/**
	 * @return the elements
	 */
	public void ajouterElement(IElementGraphique element) {
		elements.add(element);
		build();
		validate();
		repaint();
	}
	
}