package fr.julien.graphique;

import java.awt.Dimension;

import javax.swing.JPanel;

public class ZoneGraphique extends JPanel implements GraphiqueConstants{
	
	private static final long serialVersionUID = -4880690949299101279L;
	private int marge=20;
	
	public ZoneGraphique(){
		setLayout(null);
		setPreferredSize(new Dimension(LARGEUR+2*marge, HAUTEUR+2*marge));
		setSize(getPreferredSize());
		Graphique.getInstance().setBounds(marge, marge, LARGEUR, HAUTEUR);
		add(Graphique.getInstance());
	}

}
