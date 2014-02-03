package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Anomalie;
import forms.creationAnomalieForm;

/**
 * Servlet implementation class AjouterUneAnomalie
 */
@WebServlet("/AjouterUneAnomalie")
public class AjouterUneAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_ANOMALIE    = "anomalie";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";

	public static final String VUE_SUCCES             ="/WEB-INF/anomalieCree.jsp";
	
	public static final String VUE_FORMULAIRE_ANOMALIE        ="/WEB-INF/ajouterAnomalie.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUneAnomalie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_ANOMALIE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationAnomalieForm anoForm = new creationAnomalieForm();
		Anomalie ano=anoForm.CreerProjet(request);
		String message=anoForm.getMessage();
		boolean erreur=anoForm.getErreur();
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_ANOMALIE,ano );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
