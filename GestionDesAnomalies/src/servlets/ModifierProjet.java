package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Projet;
import dao.ProjetDao;
import forms.creationProjetForm;

/**
 * Servlet implementation class ModifierProjet
 */
@WebServlet("/ModifierProjet")
public class ModifierProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_PROJET     = "projet";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";
	
	public static String name   ;

	
	 public static final String VUE        = "/WEB-INF/modifierProjet.jsp";
	 public static final String VUE_MODIF        = "/WEB-INF/modificationProjet.jsp";
	 
		/**
		 * On injecte l'EJB
		 */
		@EJB
	    private ProjetDao   projetDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("nomPro");
		request.setAttribute("nomPro",name );
        this.getServletContext().getRequestDispatcher(VUE).forward( request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationProjetForm projForm =new creationProjetForm( projetDao);
		Projet proj=projForm.CreerProjet(request);
		String message=projForm.getMessage();
		boolean erreur=projForm.getErreur();
		
		
		try{
			Projet pr = projetDao.trouver(proj.getNomProjet());

			erreur=true;
			message="Le nom de projet "+pr.getNomProjet()+" est déjà utilisé <br> <a href=\"listeProjets\">Cliquez ici</a> pour revenir à la liste des projets.";
		}catch(Exception e){
			try{

				Projet p = projetDao.modifierProjet(projetDao.trouver(name),proj);

			}catch(Exception e1){
				System.out.println("catch pas");
			}
		}

		
		/* Ajout du bean et du message à l'objet requête */
		
		request.setAttribute( ATT_PROJET,proj );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_MODIF).forward( request, response );
	}

}
