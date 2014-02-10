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
 * <b>ConnectionUtilisateur est une servlet permettant de se connecter en tant qu utilisateur.
 *  C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/ConnectionUtilisateur")


public class ConnectionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ATT_ERREUR    constante donnant un nom a l attribut erreur
	 */
	public static final String ATT_ERREUR  = "erreur";
	/**
	 * ATT_RESULTAT   constante donnant un nom a l attribut message
	 */
    public static final String ATT_RESULTAT = "resultat";
    
	/**
	 * ATT_SESSION_UTIL    constante donnant un nom a l attribut session de l'utilisateur
	 */
    public static final String ATT_SESSION_UTIL = "sessionUtilisateur";
    
	/**
	 * VUE_CONNECT_UTIL    constante donnant l url de la page à afficher pour se connecter en tant qu utilisateur
	 */
	
	public static final String VUE_CONNECT_UTIL       ="/WEB-INF/connectionUtilisateur.jsp";
	
	/**
	 * VUE_SUCCES    constante donnant l url de la page à afficher en cas de succes
	 */
	public static final String VUE_SUCCES       ="/WEB-INF/menuUtilisateur.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * En cas de requete de type GET, permet d'afficher la page de formulaire à remplir pour se connecter en tant qu'utilisateur
	 * s'il n'est pas deja connecte ou si c'est deja le cas d'arriver directement sur le menu utilisateur
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
	 * Pour une requete de type POST, gere la connexion en tant qu utilisateur. En cas de succes, une session utilisateur est creee
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			connectionUtilisateurForm connectUser = new connectionUtilisateurForm();
			/* Récupération de la session depuis la requête */
	        HttpSession session = request.getSession();

	        Utilisateur user =connectUser.creerUser(request);
	        String resultatConnection=connectUser.getResultatConnection();
			boolean erreurConnection=connectUser.getErreurConnection();
			
			//Récupération des attributs de la session
			if (erreurConnection==false){
				
				session.setAttribute( ATT_SESSION_UTIL, user );
			}
			else 
			{
				session.setAttribute( ATT_SESSION_UTIL, null );
			}
	        
			

	        /* Stockage du résultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}

}
