package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Projet;
import forms.creationProjetForm;

/**
 * Servlet implementation class AjouterUnProjet
 */
@WebServlet("/AjouterUnProjet")
public class AjouterUnProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_PROJET     = "projet";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";

	public static final String VUE_SUCCES             ="/WEB-INF/projetCree.jsp";
	
	public static final String VUE_FORMULAIRE_PROJET        ="/WEB-INF/ajouterProjet.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUnProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_PROJET).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationProjetForm projForm =new creationProjetForm();
		Projet proj=projForm.CreerProjet(request);
		String message=projForm.getMessage();
		boolean erreur=projForm.getErreur();
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_PROJET,proj );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
