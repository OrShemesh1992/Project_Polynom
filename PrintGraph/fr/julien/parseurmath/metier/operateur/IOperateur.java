package fr.julien.parseurmath.metier.operateur;

import fr.julien.parseurmath.exception.CalculException;


public interface IOperateur{
	
	public double resultat(double n1, double n2) throws CalculException;
	public String getSymbole();
	public boolean isPrioritaire();

}
