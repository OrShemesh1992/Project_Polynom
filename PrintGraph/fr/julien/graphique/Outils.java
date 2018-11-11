package fr.julien.graphique;

public class Outils {
	
	private static final Outils instance = new Outils();
	
	private Outils(){
		super();
	}
	
	public boolean isDansFenetre(Graphique graphique, double x, double y){
		double maxX=graphique.getAxeX().getMax();
		double maxY=graphique.getAxeY().getMax();
		double minX=graphique.getAxeX().getMin();
		double minY=graphique.getAxeY().getMin();
		return minX <= x && x <= maxX && minY <= y && y <= maxY;
	}

	public int determinerX(Graphique graphique, double x){
		double minX=graphique.getAxeX().getMin();
		double maxX=graphique.getAxeX().getMax();
		int pas=GraphiqueConstants.LARGEUR/(int)(Math.abs(minX)+Math.abs(maxX));
		return (int) Math.floor((x+Math.abs(minX))*pas);
	}
	
	public int determinerY(Graphique graphique, double y){
		double minY=graphique.getAxeY().getMin();
		double maxY=graphique.getAxeY().getMax();
		int pas=GraphiqueConstants.HAUTEUR/(int)(Math.abs(minY)+Math.abs(maxY));
		return (int)Math.floor(((-y+maxY)*pas));
	}
	
	public static Outils getInstance() {
		return instance;
	}
	
	
}
