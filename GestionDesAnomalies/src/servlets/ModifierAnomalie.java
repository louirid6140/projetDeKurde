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
import forms.modifAnomalieFom;

/**
 * Servlet implementation class ModifierAnomalie
 */
@WebServlet("/ModifierAnomalie")
public class ModifierAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_ANOMALIE    = "anomalie";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";
	
	
	public static String sujet   ;
	/**
	 * On injecte l'EJB
	 */
	@EJB
    private AnomalieDao   anomalieDao;

	
	 public static final String VUE        = "/WEB-INF/modifierAnomalie.jsp";
	 public static final String VUE_MODIF        = "/WEB-INF/modificationAnomalie.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierAnomalie() {
        super();
 
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
		modifAnomalieFom anomalieForm =new modifAnomalieFom(anomalieDao);
		Anomalie ano=anomalieForm.CreerAnomalie(request);
		String message=anomalieForm.getMessage();
		boolean erreur=anomalieForm.getErreur();
		
		try{
		Anomalie pr = anomalieDao.trouver(ano.getSujet());
		erreur=true;
		message="Le nom de l'anomalie est déjà utilisé <br> <a href=\"listeAnomalies\">Cliquez ici</a> pour revenir à la liste des projets.";
		}catch(Exception e){
			try{
				Anomalie p = anomalieDao.modifierAnomalie(anomalieDao.trouver(sujet),ano);
			}catch(Exception e12){
				System.out.println("catch");
			}
		}
		request.setAttribute( ATT_ANOMALIE,ano );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_MODIF).forward( request, response );
	}

}
