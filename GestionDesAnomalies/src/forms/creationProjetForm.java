package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Projet;

public class creationProjetForm {
	private static final String CHAMP_NOM_PROJET   = "nomProjet";
	private static final String CHAMP_CARAC_PROJET  = "caracProjet";


	private String message;
	private Boolean erreur;



	public String getMessage() {
		return message;
	}

	public Boolean getErreur() {
		return erreur;
	}
	
	public Projet CreerProjet(HttpServletRequest request) {
		String nomProjet = getValeurChamp( request, CHAMP_NOM_PROJET );
		String caracProjet = getValeurChamp( request, CHAMP_CARAC_PROJET );

		Projet proj = new Projet();
		proj.setNomProjet(nomProjet);
		proj.setCaracProjet(caracProjet);
		
		if ( nomProjet.trim().isEmpty() || caracProjet.trim().isEmpty()  ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"projets\">Cliquez ici</a> pour accéder au formulaire de création d'un projet.";
			erreur = true;
		} else {
			message = "Projet créé avec succès !";
			erreur = false;
		}
		
		return(proj);
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
