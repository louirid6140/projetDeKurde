package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Administrateur;
import forms.connectionAdministrateurForm;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class CreationAdministrateur extends HttpServlet {
	
	
	public static final String ATT_ERREUR  = "erreur";
    public static final String ATT_RESULTAT = "resultat";

	
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
	        connectionAdministrateurForm connectAd = new connectionAdministrateurForm();
	        Administrateur admin =connectAd.creerAdmin(request);
	        String resultatConnection=connectAd.getResultatConnection();
			boolean erreurConnection=connectAd.getErreurConnection();
	        /* Stockage du résultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}

}
