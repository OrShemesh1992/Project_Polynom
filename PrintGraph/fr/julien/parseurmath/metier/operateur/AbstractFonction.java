package fr.julien.parseurmath.metier.operateur;

/**
  * <b>AbstractFonction une fonction.</b>
  *
  * @author Julien
  * @version 2.0
  */
abstract class AbstractFonction extends AbstractOperateur{
	
	public AbstractFonction(String symbole){
		super(symbole);
	}
	
	public boolean isPrioritaire(){
		return true;
	}
}
