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

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class RecuperationListeUtilisateurs
 */
@WebServlet("/RecuperationListeUtilisateurs")
public class ListerUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_CREATION = "creation";
	public static final String ATT_FORM     = "form";

	public static final String VUE = "/WEB-INF/listerUtilisateur.jsp";
	@EJB
	private UtilisateurDao utilisateurDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerUtilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, affichage de la liste
		des clients */
		
		List<Utilisateur> al = utilisateurDao.trouverTous();
		
		/* Création de la liste et des données */
		  List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
		  for(int i=0; i<=al.size()-1; i++){
			  Map<String, String> util = new HashMap<String, String>();
			  util.put("nom", al.get(i).getNom());
			  util.put("prenom", al.get(i).getPrenom());
			  util.put("email", al.get(i).getEmail());
			  util.put("login", al.get(i).getLogin());
			  liste.add(util);
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
