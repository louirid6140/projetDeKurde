package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import forms.connectionUtilisateurForm;

/**
 * Servlet implementation class ConnectionUtilisateur
 */
@WebServlet("/ConnectionUtilisateur")
public class ConnectionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_CONNECT_UTIL       ="/WEB-INF/connectionUtilisateur.jsp";
	
	//Participe � la cr�ation en dur d'un User
	public static final String VUE_SUCCES       ="/WEB-INF/menuUtilisateur.jsp";
	public static final String ATT_ERREUR  = "erreur";
    public static final String ATT_RESULTAT = "resultat";
    

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(VUE_CONNECT_UTIL ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			connectionUtilisateurForm connectUser = new connectionUtilisateurForm();

	        Utilisateur user =connectUser.creerUser(request);
	        String resultatConnection=connectUser.getResultatConnection();
			boolean erreurConnection=connectUser.getErreurConnection();
			

	        /* Stockage du r�sultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}

}
