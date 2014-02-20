package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Anomalie;
import dao.AnomalieDao;

/**
 * <b>MettreAJourForm est la classe representant le formulaire de mise à jour d'une anomalie. C'est une classe formulaire.</b>
 */
public class MettreAJourForm {
	/**
	 *  CHAMP_ETAT_ANOMALIE   constante correspondant a l etat de l'anomalie
	 */

	private static final String CHAMP_ETAT_ANOMALIE   = "etatAnomalie";

	/**
	 *message correspond au resultat de la creation en chaine de caractere
	 * e.g "creation reussie"
	 * 
	 */

	private String message;

	/**
	 *erreur correspond a un booleen vrai si il y a une erreur de creation faux sinon
	 * 
	 */
	private Boolean erreur;

	private AnomalieDao anomalieDao;
	public MettreAJourForm( AnomalieDao anomalieDao ) {
		this.anomalieDao = anomalieDao;
	}

	/**
	 * Retourne le resultat de la creation
	 * 
	 * @return resultat creation.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Retourne si il y a eu une erreur de creation ou non
	 * 
	 * @return erreur creation.
	 */
	public Boolean getErreur() {
		return erreur;
	}



	/**
	 * Retourne une anomalie en fonction des champs renseignes et
	 * determine le resultat de la creation en fonction des champs renseignes
	 * @return Anomalie
	 */
	public Anomalie CreerAnomalie(HttpServletRequest request) {
		String etatAnomalie = getValeurChamp( request, CHAMP_ETAT_ANOMALIE );


		Anomalie ano = new Anomalie();

		ano.setEtat(etatAnomalie);

		if ( etatAnomalie.trim().isEmpty() ) {
			message = "Erreur - Vous n'avez pas   rempli tous les champs obligatoires. <br> <a href=\"listeAnomalies\">Cliquez ici</a> pour accéder au formulaire de création d'un projet.";
			erreur = true;
		} else {
			message = "Anomalie mise à jour avec succés avec succès !";
			erreur = false;

		}

		return(ano);
	}

	/**
	 * Methode qui recupere la valeur des champs renseignes
	 * @param request
	 * @param nomChamp
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
