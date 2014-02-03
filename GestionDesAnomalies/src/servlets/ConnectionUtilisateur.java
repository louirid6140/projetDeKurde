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
    
    //attribut de cr�ation d'une session administrateur
    public static final String ATT_SESSION_UTIL = "sessionUtilisateur";
       
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
		
		HttpSession session = request.getSession();
		if(session.getAttribute(ATT_SESSION_UTIL)==null){
			this.getServletContext().getRequestDispatcher(VUE_CONNECT_UTIL).forward( request, response );
		}
		else{
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			connectionUtilisateurForm connectUser = new connectionUtilisateurForm();
			/* R�cup�ration de la session depuis la requ�te */
	        HttpSession session = request.getSession();

	        Utilisateur user =connectUser.creerUser(request);
	        String resultatConnection=connectUser.getResultatConnection();
			boolean erreurConnection=connectUser.getErreurConnection();
			
			//R�cup�ration des attributs de la session
			if (erreurConnection==false){
				
				session.setAttribute( ATT_SESSION_UTIL, user );
			}
			else 
			{
				session.setAttribute( ATT_SESSION_UTIL, null );
			}
	        
			

	        /* Stockage du r�sultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}

}
