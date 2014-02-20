package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Anomalie;
import dao.AnomalieDao;

public class modifAnomalieFom {
	/**
	 * CHAMP_SUJET_ANOMALIE  constante correspondant au sujet de l'anomalie
	 */
	private static final String CHAMP_SUJET_ANOMALIE  = "sujetAnomalie";

	/**
	 * CHAMP_DES_ANOMALIE  constante correspondant a la description de l'anomalie
	 */
	private static final String CHAMP_DES_ANOMALIE  = "desAnomalie";	

	/**
	 *  CHAMP_NOTE_ANOMALIE   constante correspondant a une note sur l'anomalie
	 */
	private static final String CHAMP_NOTE_ANOMALIE  = "noteAnomalie";

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
	public modifAnomalieFom( AnomalieDao anomalieDao ) {
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
		String sujetAnomalie = getValeurChamp( request, CHAMP_SUJET_ANOMALIE );
		String desAnomalie = getValeurChamp( request, CHAMP_DES_ANOMALIE );
		String noteAnomalie = getValeurChamp( request, CHAMP_NOTE_ANOMALIE );


		Anomalie ano = new Anomalie();

		ano.setSujet(sujetAnomalie);
		ano.setDescription(desAnomalie);
		ano.ajouterNote(noteAnomalie);

		if ( sujetAnomalie.trim().isEmpty() || desAnomalie.trim().isEmpty()
				||noteAnomalie.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas  ++ rempli tous les champs obligatoires. <br> <a href=\"projets\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un projet.";
			erreur = true;
		} else {
			message = "Anomalie cr�� ou modifi� avec succ�s !";
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
