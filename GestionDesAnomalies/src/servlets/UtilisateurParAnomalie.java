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
 * Servlet implementation class UtilisateurParAnomalie
 */
@WebServlet("/UtilisateurParAnomalie")
public class UtilisateurParAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE        = "/WEB-INF/utilisateurParAnomalie.jsp";
	@EJB
	private AnomalieDao anomalieDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurParAnomalie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("login");
		List<Anomalie> al = anomalieDao.trouverTous();
		List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).getUtilisateur().getLogin());
			if(al.get(i).getUtilisateur().getLogin().equals(name)){
				Map<String, String> anom = new HashMap<String, String>();
				anom.put("sujet", al.get(i).getSujet());
				anom.put("description", al.get(i).getDescription());
				anom.put("etat", al.get(i).getEtat());
				anom.put("notes", al.get(i).getNotes());
				anom.put("utilisateur", al.get(i).getUtilisateur().getLogin());
				anom.put("projet", al.get(i).getProjet().getNomProjet());
				liste.add(anom);
			}
		}
		request.setAttribute( "login",name );
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
