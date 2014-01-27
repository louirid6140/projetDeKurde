package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Administrateur;
import beans.Utilisateur;

public class connectionUtilisateurForm {
	
	//ICI ON CREE POUR LE MOMENT EN DUR UN USER MAIS IL FAUDRA aller le chercher dans la BDD
	public static final String CHAMP_LOGIN   = "login";
	public static final String CHAMP_PASSWORD   = "password";

	/**
	 * MDP et login de l'administrateur créer des le départ
	 */
	public static final String LOGIN   = "user";
	public static final String PASSWORD   = "user";

	private String resultatConnection;
	private Boolean erreurConnection;
	public String getResultatConnection() {
		return resultatConnection;
	}
	public Boolean getErreurConnection() {
		return erreurConnection;
	}
	
	public Utilisateur creerUser(HttpServletRequest request) {
		String loginUser = getValeurChamp( request, CHAMP_LOGIN );
		String passwordUser = getValeurChamp( request, CHAMP_PASSWORD );
		Utilisateur user = new Utilisateur();
		user.setLogin(loginUser);
		user.setPassword(passwordUser);	
		erreurConnection=false;
		  try {
	            validationConnectionAdmin(loginUser,passwordUser);
	        } catch (Exception e) {
	        	erreurConnection=true;
	        }
		  /* Initialisation du résultat global de la validation. */
	        if ( erreurConnection==false ) {
	        	resultatConnection = "Connection résussie.";
	        } else {
	        	resultatConnection = "Echec de la connection.";
	        }
		
		return user;
		
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
