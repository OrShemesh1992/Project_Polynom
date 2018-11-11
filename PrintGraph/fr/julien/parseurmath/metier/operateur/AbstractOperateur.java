package fr.julien.parseurmath.metier.operateur;

/**
  * <b>AbstractOperateur represente un operateur.</b>
  * <p>
  * Un AbstractOperateur est caracterise par les inforamtions :
  * <ul>
  * <li>Un symbole +, -, cos,...</li>
  * </ul>
  * </p>
  *
  * @author Julien
  * @version 2.0
  */
abstract class AbstractOperateur implements IOperateur{
	
	/** 
	  * Symbole correspondant
	  */
	private String symbole;
	
	/**
	 * Constructeur d'un operateur
	 * @param symbole
	 * 		Symbole de l'operateur
	 */
	public AbstractOperateur(String symbole){
		this.symbole=symbole;
	}
	
	/**
	  * Accesseur au symbole
	  * @return le symbole de l'operateur
	  */
	public String getSymbole() {
		return symbole;
	}

}
