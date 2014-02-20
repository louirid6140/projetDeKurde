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

import beans.Projet;
import dao.ProjetDao;

/**
 * Servlet implementation class ListerProjets
 */
@WebServlet("/ListerProjets")
public class ListerProjets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String ATT_CREATION = "creation";
	 public static final String ATT_FORM     = "form";
	 
	 public static final String VUE        = "/WEB-INF/listerProjet.jsp";
	 @EJB
	 private ProjetDao projetDao;
      
   /**
    * @see HttpServlet#HttpServlet()
    */
   public ListerProjets() {
       super();
       // TODO Auto-generated constructor stub
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, affichage de la liste
		des clients */
		List<Projet> al = projetDao.trouverTous();

		/* Création de la liste et des données */
		List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
		for(int i=0; i<=al.size()-1; i++){
			Map<String, String> proj = new HashMap<String, String>();
			proj.put("nomProjet", al.get(i).getNomProjet());
			proj.put("caracProjet", al.get(i).getCaracProjet());
			liste.add(proj);
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
