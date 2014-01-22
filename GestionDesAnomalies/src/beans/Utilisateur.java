package beans;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNom( String nom ) {
		this.nom = nom;
	}

	public void setLogin( String login ) {
		this.login = login;
	}

	public void setPassword( String password ) {

		this.password = password;
	}
}
