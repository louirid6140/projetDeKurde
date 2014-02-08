package beans;
/**
 * <b>Administrateur est la classe representant l'administrateur de notre systeme. C'est une classe bean.</b>
 * <p>
 * L'administrateur est caractérisé par:
 * <ul>
 * <li>le login (qui sera "admin" par default)</li>
 * <li>un mot de passe(également admin par default)</li>
 * </ul>
 * </p>
 */
public class Administrateur {
    /**
     *login correspond au pseudo de l'administrateur
     * e.g "admin"
     * 
     */
	private String login;
	
    /**
     *password correspond au mot de passe qui permettra à l'administrateur de se connecter
     * e.g "admin"
     * 
     */
	private String password;
	
    /**
     * Constructeur d'un administrateur
     */
	public Administrateur() {
		super();
	}

    /**
     * Retourne le pseudo de l'administrateur
     * 
     * @return login de l'administrateur.
     */

	public String getLogin() {
		return this.login;
	}
	
    /**
     * Retourne le mot de passe de l'administrateur
     * 
     * @return mot de passe de l'administrateur.
     */
	public String getPassword() {
		return this.password;
	}

    /**
     * Met a jour le login de l'administrateur.
     * 
     * @param login
     * 
     */

	public void setLogin( String login ) {
		this.login = login;
	}
	
    /**
     * Met a jour le mot de passe  de l'administrateur.
     * 
     * @param password
     * 
     */
	public void setPassword( String password ) {

		this.password = password;
	}
}
