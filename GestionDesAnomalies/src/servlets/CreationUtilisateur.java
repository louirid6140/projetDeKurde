package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.creationUtilisateurForm;
import beans.Utilisateur;

/**
 * Servlet implementation class CreationUtilisateur
 */
@WebServlet("/CreationUtilisateur")
public class CreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public static final String ATT_UTILISATEUR     = "utilisateur";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";

	public static final String VUE_SUCCES             ="/WEB-INF/utilisateurCree.jsp";
	
	public static final String VUE_FORMULAIRE_CREATION         ="/WEB-INF/creerUtilisateur.jsp";
	



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_CREATION).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationUtilisateurForm utilForm = new creationUtilisateurForm();
		Utilisateur util=utilForm.CreerUtilisateur(request);
		String message=utilForm.getMessage();
		boolean erreur=utilForm.getErreur();
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_UTILISATEUR,util );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
