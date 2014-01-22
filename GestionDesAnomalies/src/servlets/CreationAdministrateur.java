package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Administrateur;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class CreationAdministrateur extends HttpServlet {
	public static final String CHAMP_LOGIN   = "login";
	public static final String CHAMP_PASSWORD   = "password";
	
	public static final String ATT_ERREUR  = "erreur";
    public static final String ATT_RESULTAT = "resultat";
	/**
	 * MDP et login de l'administrateur créer des le départ
	 */
	public static final String LOGIN   = "admin";
	public static final String PASSWORD   = "admin";
	
	public static final String VUE_FORM_CONNECT ="/WEB-INF/connectionAdministrateur.jsp";
	public static final String VUE_SUCCES ="/WEB-INF/menuAdministrateur.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationAdministrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(VUE_FORM_CONNECT).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean erreurConnection=false;
		String resultatConnection="";
		String loginAdmin = request.getParameter(CHAMP_LOGIN );
		String passwordAdmin = request.getParameter(CHAMP_PASSWORD );
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
	        
	        /* Stockage du résultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}
	private void validationConnectionAdmin( String login, String password ) throws Exception{
			if(login.equals(LOGIN)==false||password.equals(PASSWORD)==false){
				 throw new Exception( "Le pseudo et/ou le mot de passe sont incorrects" );
			}
		
	}

}
