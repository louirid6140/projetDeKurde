package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>DeconnectionSession est une servlet permettant de deconnecter un administrateur ou un utilisateur de sa session. C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/DeconnectionSession")


public class DeconnectionSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * URL_REDIRECTION    constante donnant l url de la page à afficher en cas de deconnexion: 
	 * Il s'agit en fait du menu principal
	 */
	public static final String URL_REDIRECTION ="http://localhost:8080/GestionDesAnomalies/connection";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeconnectionSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet de deconnecter un utilisateur ou un administrateur en cas de requete de type GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération et destruction de la session en cours */
		HttpSession session = request.getSession();
		session.invalidate();
		/* Redirection vers le Site du Zéro ! */
		response.sendRedirect( URL_REDIRECTION );
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
