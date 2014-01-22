package beans;

public class Administrateur {
	private String login;
	private boolean password;



	public String getLogin() {
		return this.login;
	}

	public boolean getPassword() {
		return this.password;
	}


	public void setLogin( String login ) {
		this.login = login;
	}

	public void setPassword( String password ) {

		this.password = true;
	}
}
