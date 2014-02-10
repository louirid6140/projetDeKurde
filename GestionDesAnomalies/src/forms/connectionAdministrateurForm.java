package forms;

import javax.servlet.http.HttpServletRequest;

import beans.Administrateur;

/**
 * <b>connectionAdministrateurForm est la classe representant le formulaire de connexion de l'administrateur. C'est une classe formulaire.</b>
 * <p>
 *  Cette classe est caracterisee par:
 * <ul>
 * <li>le resultat de la connexion (sous forme de chaine de caractere)</li>
 * <li>l'erreur ou non de la connexion (booleen)</li>
 * </ul>
 * </p>
 */

public class connectionAdministrateurForm {
	
	/**
	 * CHAMP_LOGIN  constante correspondant au nom du champ login
	 */

	public static final String CHAMP_LOGIN   = "login";
	
	/**
	 * CHAMP_PASSWORD   constante correspondant au nom du champ mot de passe
	 */
	public static final String CHAMP_PASSWORD   = "password";

	/**
	 * LOGIN constante du pseudo de l'administrateur genere au premier deploiement de l'application
	 * LOGIN="admin" par default
	 */
	public static final String LOGIN   = "admin";
	
	/**
	 * PASSWORD constante du mot de passe de l'administrateur genere au premier deploiement de l'application
	 * PASSWORD="admin" par default
	 */
	public static final String PASSWORD   = "admin";
	
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
	 * Retourne un administrateur en fonction des champs renseignes et
	 * determine le resultat de la connexion en fonction des champs renseignes
	 * @return Administrateur
	 */
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
	        	resultatConnection = "Connexion résussie.";
	        } else {
	        	resultatConnection = "Echec de la connexion.";
	        }
		
		return admin;
		
	}
	
	/**
	 * Methode qui determine si le login et le mot de passe de l'administrateur sont corrects
	 * @param login
	 * @param password
	 */
	private void validationConnectionAdmin( String login, String password ) throws Exception{
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
