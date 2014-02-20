package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Anomalie;
import dao.AnomalieDao;

/**
 * Servlet implementation class ListerAnomalie
 */
@WebServlet("/ListerAnomalie")
public class ListerAnomalie extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String ATT_CREATION = "creation";
	public static final String ATT_FORM     = "form";

	public static final String VUE        = "/WEB-INF/listeAnomalie.jsp";
	@EJB
	private AnomalieDao anomalieDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerAnomalie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, affichage de la liste
		des anomalies */
		List<Anomalie> al = anomalieDao.trouverTous();

		/* Création de la liste et des données */
		List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
		for(int i=0; i<=al.size()-1; i++){
			//System.out.println("Utilisateur "+i+" : "+al.get(i).getUtilisateur().getLogin());
			if(al.get(i).isAffecte()){

				Map<String, String> anom = new HashMap<String, String>();
				anom.put("sujet", al.get(i).getSujet());
				anom.put("description", al.get(i).getDescription());
				anom.put("etat", al.get(i).getEtat());
				//anom.put("nomUtilisateurAff", al.get(i).getNomUtilisateurAff());
				anom.put("notes", al.get(i).getNotes());
				anom.put("utilisateur", al.get(i).getUtilisateur().getLogin());
				anom.put("projet", al.get(i).getNomProjetAff());
				liste.add(anom);
				
			}
		}		

		request.setAttribute( "liste", liste );
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
