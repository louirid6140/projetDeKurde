package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

@Entity
public class Administrateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id_admin;

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
	@Column(name = "mot_de_passe")
	private String password;
	
    /**
     * Constructeur d'un administrateur
     */
	public Administrateur() {
		super();
	}
	
	/**
	 * 
	 * @return id de l'adiminstrateur
	 */
    public Long getId_admin() {
		return id_admin;
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
