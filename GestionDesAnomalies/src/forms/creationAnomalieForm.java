package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Anomalie;


public class creationAnomalieForm {
	private static final String CHAMP_SUJET_ANOMALIE  = "sujetAnomalie";
	private static final String CHAMP_DES_ANOMALIE  = "desAnomalie";	
	private static final String CHAMP_ETAT_ANOMALIE   = "etatAnomalie";
	private static final String CHAMP_UTIL_ANOMALIE = "utilAnomalie";
	private static final String CHAMP_NOTE_ANOMALIE  = "noteAnomalie";


	private String message;
	private Boolean erreur;



	public String getMessage() {
		return message;
	}

	public Boolean getErreur() {
		return erreur;
	}
	
	public Anomalie CreerProjet(HttpServletRequest request) {
		String sujetAnomalie = getValeurChamp( request, CHAMP_SUJET_ANOMALIE );
		String desAnomalie = getValeurChamp( request, CHAMP_DES_ANOMALIE );
		String etatAnomalie = getValeurChamp( request, CHAMP_ETAT_ANOMALIE );
		String utilAnomalie = getValeurChamp( request, CHAMP_UTIL_ANOMALIE );
		String noteAnomalie = getValeurChamp( request, CHAMP_NOTE_ANOMALIE );
		
		System.out.println(request.getParameter( CHAMP_ETAT_ANOMALIE ));
		
		

		Anomalie ano = new Anomalie();
		ano.setSujet(sujetAnomalie);
		ano.setDescription(desAnomalie);
		ano.setEtat(etatAnomalie);
		ano.setNomtUtilisateurAff(utilAnomalie);
		ano.ajouterNote(noteAnomalie);
		
		if ( sujetAnomalie.trim().isEmpty() || desAnomalie.trim().isEmpty() || etatAnomalie.trim().isEmpty() || utilAnomalie.trim().isEmpty()
				||noteAnomalie.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"projets\">Cliquez ici</a> pour accéder au formulaire de création d'un projet.";
			erreur = true;
		} else {
			message = "Anomalie créée avec succès !";
			erreur = false;
		}
		
		return(ano);
	}

	/*
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
