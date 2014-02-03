package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;

public class creationUtilisateurForm {
	private static final String CHAMP_NOM   = "nomUtilisateur";
	private static final String CHAMP_PRENOM   = "prenomUtilisateur";
	private static final String CHAMP_MAIL   = "emailUtilisateur";
	private static final String CHAMP_LOGIN   = "loginUtilisateur";
	private static final String CHAMP_PASSWORD   = "passwordUtilisateur";
	
	private String message;
	private Boolean erreur;
	
	

	public String getMessage() {
		return message;
	}

	public Boolean getErreur() {
		return erreur;
	}

	public Utilisateur CreerUtilisateur(HttpServletRequest request) {
		String nom = getValeurChamp( request, CHAMP_NOM );
		String prenom = getValeurChamp( request, CHAMP_PRENOM );
		String adresse = getValeurChamp( request, CHAMP_MAIL  );
		String login = getValeurChamp( request, CHAMP_LOGIN);
		String password = getValeurChamp( request, CHAMP_PASSWORD  );
		Utilisateur util = new Utilisateur();
		util.setNom( nom );
		util.setPrenom( prenom );
		util.setEmail( adresse );
		util.setLogin( login );
		util.setPassword( password);
		
		if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ||
				adresse.trim().isEmpty() ||login.trim().isEmpty() ||password.trim().isEmpty() ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerUtilisateur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un utilisateur.";
			erreur = true;
		} else {
			message = "Utilisateur créé avec succès !";
			erreur = false;
		}
		
		return(util);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp( HttpServletRequest
			request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return "";
		} else {
			return valeur;
		}
	}
	
}

