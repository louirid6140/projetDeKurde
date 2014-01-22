package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Administrateur;


public class connectionAdministrateurForm {

	public static final String CHAMP_LOGIN   = "login";
	public static final String CHAMP_PASSWORD   = "password";

	/**
	 * MDP et login de l'administrateur créer des le départ
	 */
	public static final String LOGIN   = "admin";
	public static final String PASSWORD   = "admin";

	private String resultatConnection;
	private Boolean erreurConnection;

	


	public String getResultatConnection() {
		return resultatConnection;
	}
	public Boolean getErreurConnection() {
		return erreurConnection;
	}
	public Administrateur creerAdmin(HttpServletRequest request) {
		String loginAdmin = getValeurChamp( request, CHAMP_LOGIN );
		String passwordAdmin = getValeurChamp( request, CHAMP_PASSWORD );
		Administrateur admin = new Administrateur();
		admin.setLogin(loginAdmin);
		admin.setPassword(passwordAdmin);	
		erreurConnection=false;
		  try {
	            validationConnectionAdmin(loginAdmin,passwordAdmin);
	        } catch (Exception e) {
	        	erreurConnection=true;
	        }
		  /* Initialisation du résultat global de la validation. */
	        if ( erreurConnection==false ) {
	        	resultatConnection = "Connection résussie.";
	        } else {
	        	resultatConnection = "Echec de la connection.";
	        }
		
		return admin;
		
	}
	private void validationConnectionAdmin( String login, String password ) throws Exception{
		if(login.equals(LOGIN)==false||password.equals(PASSWORD)==false){
			throw new Exception( "Le pseudo et/ou le mot de passe sont incorrects" );
		}

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
