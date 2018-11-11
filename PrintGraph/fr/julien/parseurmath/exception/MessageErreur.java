package fr.julien.parseurmath.exception;

public class MessageErreur {
	
	private static final String PREFIX_ANALYSE = "[ERREUR-ANALYSE]";
	private static final String PREFIX_SYNTAXE = "[ERREUR-SYNTAXE]";
	private static final String PREFIX_CALCUL = "[ERREUR-CALCUL]";
	private static final String PREFIX_PARSING = "[ERREUR-PARSING]";
	public static final String ERREUR_DIVISION_ZERO = PREFIX_CALCUL + " Division par 0";
	public static final String ERREUR_TANJENTE = PREFIX_CALCUL + " Tanjente non definie pour cette valeur";
	public static final String ERREUR_ASIN = PREFIX_CALCUL + " Arcsin non definit pour cette valeur";
	public static final String ERREUR_ACOS = PREFIX_CALCUL + " Arccos non definit pour cette valeur";
	public static final String ERREUR_RACINE = PREFIX_CALCUL + " Racine non define pour cette valeur";
	public static final String ERREUR_LN = PREFIX_CALCUL + " Logarithme non definit pour cette valeur";
	public static final String ERREUR_CALCUL = PREFIX_CALCUL + " Impossible d'effectuer le calcul";
	public static final String ERREUR_OPERATEUR_INEXISTANT = PREFIX_SYNTAXE + " L'operateur correspondant n'existe pas";
	public static final String ERREUR_OPERATEUR = PREFIX_ANALYSE + " L'operateur n'existe pas";
	public static final String ERREUR_ANALYSE = PREFIX_ANALYSE + " Erreur d'analyse de la chaine de caracteres";
	public static final String ERREUR_CREATION_ARBRE = PREFIX_ANALYSE + " Impossible de creer l'arbre";
	public static final String ERREUR_PARSING_ARBRE = PREFIX_PARSING + " Impossible de creer l'arbre correspondant a l'equation";
	public static final String ERREUR_CALCUL_ARBRE = PREFIX_PARSING + " Le calcul de la valeur est impossible";


}
