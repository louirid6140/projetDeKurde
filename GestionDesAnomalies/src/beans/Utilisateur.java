package beans;

/**
 * <b>Utilisateur est la classe representant un utilisateur du systeme. C'est une classe bean.</b>
 * <p>
 *  Un utilisateur est caracterise par:
 * <ul>
 * <li>un nom</li>
 * <li>un prenom</li>
 * <li>une adresse email</li>
 * <li>un pseudo</li>
 * <li>un mot de passe</li>
 * </ul>
 * </p>
 */
public class Utilisateur {
    /**
     *nom correspond au nom de l'utilisateur
     * e.g "Loir-Mongazon"
     * 
     */
	private String nom;
    /**
     *prenom correspond au prenom de l'utilisateur
     * e.g "Romain"
     * 
     */
	private String prenom;
	
    /**
     *email correspond à l'adresse electronique de l'utilisateur
     * e.g "romain.loir@datascientist.fr"
     * 
     */
	private String email;
	
    /**
     *login correspond au pseudo de l'utilisateur
     * e.g "rlm"
     * 
     */
	private String login;
	
    /**
     *password correspond au mot de passe de l'utilisateur
     * e.g "motDePasse"
     * 
     */
	private String password;
	
    /**
     * Retourne le prenom de l'utilisateur
     * 
     * @return prenom utilisateur.
     */
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

    /**
     * Retourne l email de l'utilisateur
     * 
     * @return email utilisateur.
     */
	public String getEmail() {
		return email;
	}
	
	  /**
     * Met a jour le mail de l'utilisateur.
     * 
     * @param email
     * 
     */

	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * Retourne le nom de l'utilisateur
     * 
     * @return nom utilisateur.
     */
	public String getNom() {
		return this.nom;
	}
	
    /**
     * Retourne le login de l'utilisateur
     * 
     * @return login utilisateur.
     */
	public String getLogin() {
		return this.login;
	}
	
    /**
     * Retourne le mot de passe de l'utilisateur
     * 
     * @return mot de passe utilisateur.
     */
	public String getPassword() {
		return this.password;
	}
	
	 /**
     * Met a jour le nom de l'utilisateur.
     * 
     * @param nom
     * 
     */
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	  /**
     * Met a jour le login de l'utilisateur.
     * 
     * @param login
     * 
     */

	public void setLogin( String login ) {
		this.login = login;
	}
	
    /**
     * Met a jour le mot de passe de l'utilisateur.
     * 
     * @param password
     * 
     */

	public void setPassword( String password ) {

		this.password = password;
	}
}
