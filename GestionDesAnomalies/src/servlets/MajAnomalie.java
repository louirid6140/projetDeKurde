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
import forms.MettreAJourForm;

/**
 * Servlet implementation class MajAnomalie
 */
@WebServlet("/MajAnomalie")
public class MajAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ANOMALIE    = "anomalie";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";


	public static String sujet  ;
	/**
	 * On injecte l'EJB
	 */
	@EJB
	private AnomalieDao   anomalieDao;


	public static final String VUE        = "/WEB-INF/majAnomalie.jsp";
	public static final String VUE_MODIF        = "/WEB-INF/majAnomalieOk.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MajAnomalie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sujet = request.getParameter("sujet");
		request.setAttribute("sujet",sujet );
		this.getServletContext().getRequestDispatcher(VUE).forward( request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MettreAJourForm anomalieForm =new MettreAJourForm(anomalieDao);
		Anomalie ano=anomalieForm.CreerAnomalie(request);
		String message=anomalieForm.getMessage();
		boolean erreur=anomalieForm.getErreur();


		try{
			Anomalie p = anomalieDao.MajAnomalie(anomalieDao.trouver(sujet),ano);
		}catch(Exception e12){
			System.out.println("catch");
		}
		request.setAttribute( ATT_ANOMALIE,ano );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_MODIF).forward( request, response );
	}
}


