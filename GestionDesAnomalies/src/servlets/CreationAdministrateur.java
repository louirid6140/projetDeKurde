package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrateur;
import forms.connectionAdministrateurForm;

/**
 * <b>CreationAdministrateur est une servlet permettant de creer l administrateur.
 * ATTENTION ! Cette servlet est utilisee des le premier deploiement.
 *  C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/Servlet")

public class CreationAdministrateur extends HttpServlet {
	
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
	 * ATT_SESSION_ADMIN   constante donnant un nom a l attribut session de l'administrateur
	 */
    
    public static final String ATT_SESSION_ADMIN = "sessionAdministrateur";

	/**
	 * VUE_FORM_CONNECT    constante donnant l url de la page à afficher pour se connecter en tant qu administrateur
	 */
	
	
	public static final String VUE_FORM_CONNECT ="/WEB-INF/connectionAdministrateur.jsp";
	
	/**
	 * VUE_SUCCES    constante donnant l url de la page à afficher en cas de succes
	 */
	public static final String VUE_SUCCES ="/WEB-INF/menuAdministrateur.jsp";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationAdministrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * En cas de requete de type GET, permet d'afficher la page de formulaire à remplir pour se connecter en tant qu'administrateur
	 * s'il n'est pas deja connecte ou si c'est deja le cas d'arriver directement sur le menu administrateur
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(ATT_SESSION_ADMIN)==null){
			this.getServletContext().getRequestDispatcher(VUE_FORM_CONNECT).forward( request, response );
		}
		else{
			this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
		}
	}

	/**
	 * Pour une requete de type POST, gere la connexion en tant qu adminstrateur. En cas de succes, une session administrateur est creee
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        connectionAdministrateurForm connectAd = new connectionAdministrateurForm();
			/* Récupération de la session depuis la requête */
	        HttpSession session = request.getSession();
	        
	        Administrateur admin =connectAd.creerAdmin(request);
	        String resultatConnection=connectAd.getResultatConnection();
			boolean erreurConnection=connectAd.getErreurConnection();
			//Récupération des attributs de la session
			if (erreurConnection==false){
				
				session.setAttribute( ATT_SESSION_ADMIN, admin );
			}
			else 
			{
				session.setAttribute( ATT_SESSION_ADMIN, null );
			}
	        /* Stockage du résultat et des messages d'erreur dans
	        l'objet request */
	        request.setAttribute( ATT_ERREUR, erreurConnection );
	        request.setAttribute( ATT_RESULTAT, resultatConnection );
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES).forward( request, response );
	}

}
