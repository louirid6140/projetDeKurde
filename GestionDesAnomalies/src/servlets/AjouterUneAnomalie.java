package servlets;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Anomalie;
import dao.AnomalieDao;
import forms.creationAnomalieForm;

/**
 * <b>AjouterUneAnomalie est une servlet permettant d'ajouter une anomalie. C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */

@WebServlet("/AjouterUneAnomalie")
public class AjouterUneAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ATT_ANOMALIE   constante donnant un nom a l attribut anomalie
	 */
	public static final String ATT_ANOMALIE    = "anomalie";

	/**
	 * ATT_MESSAGE   constante donnant un nom a l attribut message
	 */
	public static final String ATT_MESSAGE     = "message";

	/**
	 * ATT_ERREUR    constante donnant un nom a l attribut erreur
	 */
	public static final String ATT_ERREUR      = "erreur";

	/**
	 * VUE_SUCCES    constante donnant l url de la page à afficher en cas de succes
	 */

	public static final String VUE_SUCCES       ="/WEB-INF/anomalieCree.jsp";

	/**
	 * VUE_FORMULAIRE_ANOMALIE    constante donnant l url de la page à afficher pour creer une anomalie
	 */

	public static final String VUE_FORMULAIRE_ANOMALIE        ="/WEB-INF/ajouterAnomalie.jsp";

	/**
	 * On injecte l'EJB
	 */
	@EJB
	private AnomalieDao   anomalieDao;

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
	 * Permet de creer une anomalie et d'afficher la page de de synthese de l anomalie en cas de succes et pour une requte de type POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationAnomalieForm anoForm = new creationAnomalieForm(anomalieDao);
		Anomalie ano=anoForm.CreerAnomalie(request);
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
