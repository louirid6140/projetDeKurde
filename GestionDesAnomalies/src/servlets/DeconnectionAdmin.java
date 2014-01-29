package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeconnectionAdmin
 */
@WebServlet("/DeconnectionAdmin")
public class DeconnectionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String URL_REDIRECTION ="http://localhost:8080/GestionDesAnomalies/connection";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeconnectionAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* R�cup�ration et destruction de la session en cours */
		HttpSession session = request.getSession();
		session.invalidate();
		/* Redirection vers le Site du Z�ro ! */
		response.sendRedirect( URL_REDIRECTION );
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
