package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Administrateur;
import beans.Utilisateur;
/**
 * <b>connectionUtilisateurForm est la classe representant le formulaire de connexion d'un utilisateur. C'est une classe formulaire.</b>
 * <p>
 *  Cette classe est caracterisee par:
 * <ul>
 * <li>le resultat de la connexion (sous forme de chaine de caractere)</li>
 * <li>l'erreur ou non de la connexion (booleen)</li>
 * </ul>
 * </p>
 */

public class connectionUtilisateurForm {

	
	/**
	 * CHAMP_LOGIN  constante correspondant au nom du champ login
	 */
	public static final String CHAMP_LOGIN   = "login";
	
	/**
	 * CHAMP_PASSWORD   constante correspondant au nom du champ mot de passe
	 */
	public static final String CHAMP_PASSWORD   = "password";

	/**
	 * MDP et login de l'administrateur créer des le départ
	 */
	public static final String LOGIN   = "user";
	public static final String PASSWORD   = "user";
	
    /**
     *resultatConnection correspond au resultat de la connexion en chaine de caractere
     * e.g "Connexion reussie"
     * 
     */
	private String resultatConnection;
	
    /**
     *erreurConnection correspond a un booleen vrai si il y a une erreur de connexion faux sinon
     * 
     */
	private Boolean erreurConnection;
	
    /**
     * Retourne le resultat de la connexion
     * 
     * @return resultat connexion.
     */
	public String getResultatConnection() {
		return resultatConnection;
	}
	
    /**
     * Retourne si il y a eu une erreur de connexion ou non
     * 
     * @return erreur connexion.
     */
	public Boolean getErreurConnection() {
		return erreurConnection;
	}
	
	/**
	 * Retourne un utilisateur en fonction des champs renseignes et
	 * determine le resultat de la connexion en fonction des champs renseignes
	 * @return Utilisateur
	 */
	
	public Utilisateur creerUser(HttpServletRequest request) {
		String loginUser = getValeurChamp( request, CHAMP_LOGIN );
		String passwordUser = getValeurChamp( request, CHAMP_PASSWORD );
		Utilisateur user = new Utilisateur();
		user.setLogin(loginUser);
		user.setPassword(passwordUser);	
		erreurConnection=false;
		  try {
	            validationConnectionUtil(loginUser,passwordUser);
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
	
	/**
	 * Methode qui determine si le login et le mot de passe de l'utilisateur sont corrects
	 * @param login
	 * @param password
	 */
	private void validationConnectionUtil( String login, String password ) throws Exception{
		if(login.equals(LOGIN)==false||password.equals(PASSWORD)==false){
			throw new Exception( "Le pseudo et/ou le mot de passe sont incorrects" );
		}

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
