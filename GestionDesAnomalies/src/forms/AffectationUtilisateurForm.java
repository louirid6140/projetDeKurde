package forms;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import beans.Anomalie;
import beans.Utilisateur;
import dao.AnomalieDao;
import dao.UtilisateurDao;

/**
 * <b>AffectationUtilisateurForm est la classe representant le formulaire d'affectation d'un utilisateur. C'est une classe formulaire.</b>
 */
public class AffectationUtilisateurForm {
	/**
	 * CHAMP_ANOMALIE  constante correspondant au sujet de l'anomalie
	 */
	public static final String CHAMP_ANOMALIE   = "SujetAnomalies";
	/**
	 * CHAMP_UTILISATEUR constante correspondant à l'utilisateur affecte
	 */
	public static final String CHAMP_UTILISATEUR   = "UtilisateurName";

	/**
	 *resultat correspond au resultat de la creation en chaine de caractere
	 * e.g "affectation reussie"
	 * 
	 */
	private String resultat;
	/**
	 *erreur correspond a un booleen vrai si il y a une erreur de creation faux sinon
	 * 
	 */
	private Boolean erreur;
	
	private String champ1;
	private String champ2;

	private AnomalieDao anomalieDao;
	private UtilisateurDao utilisateurDao;
	
	public AffectationUtilisateurForm(AnomalieDao anomalieDao, UtilisateurDao utilisateurDao){
		this.anomalieDao = anomalieDao;
		this.utilisateurDao = utilisateurDao;
	}

	public void setChamp1(String champ1) {
		this.champ1 = champ1;
	}
	public void setChamp2(String champ2) {
		this.champ2 = champ2;
	}
	public String getChamp1() {
		return champ1;
	}
	public String getChamp2() {
		return champ2;
	}
	public String getResultat() {
		return resultat;
	}
	public Boolean getErreur() {
		return erreur;
	}

	/** Methode qui recupere les champs d affectation d'une anomalie
	 */
	public Anomalie affectationAnomalie (HttpServletRequest request) {
		champ1=getValeurChamp( request,CHAMP_UTILISATEUR);
		champ2=getValeurChamp( request,CHAMP_ANOMALIE);
		erreur=false;
		Anomalie ano = new Anomalie();
		try {
			Utilisateur ut = utilisateurDao.trouver(champ1);
			ano = anomalieDao.trouver(champ2);
			ano.setUtilisateur(ut);
		} catch (Exception e) {
			erreur=true;
			ano=null;
		}
		/* Initialisation du résultat global de la validation. */
		if ( erreur==false ) {
			resultat = "Affectation confirmée.";
		} else {
			resultat = "Echec de l'affectation.";
		}
		return(ano);
	}

	/**
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 *
	 *
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return "";
		} else {
			return valeur;
		}
	}
}


