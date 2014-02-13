package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.creationUtilisateurForm;

/**
 * <b>CreationUtilisateur est une servlet permettant d'ajouter un utilisateur. C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/CreationUtilisateur")



public class CreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ATT_ANOMALIE   constante donnant un nom a l attribut utilisateur
	 */
	public static final String ATT_UTILISATEUR     = "utilisateur";
	
	/**
	 * ATT_MESSAGE   constante donnant un nom a l attribut message
	 */
	public static final String ATT_MESSAGE     = "message";
	
	/**
	 * ATT_ERREUR    constante donnant un nom a l attribut erreur
	 */
	public static final String ATT_ERREUR      = "erreur";
	
	/**
	 * VUE_SUCCES    constante donnant l url de la page à afficher en cas de succes
	 */
	public static final String VUE_SUCCES ="/WEB-INF/utilisateurCree.jsp";
	
	/**
	 * VUE_FORMULAIRE_ANOMALIE    constante donnant l url de la page à afficher pour creer un projet
	 */
	
	
	public static final String VUE_FORMULAIRE_CREATION         ="/WEB-INF/creerUtilisateur.jsp";
	
	/**
	 * On injecte l'EJB
	 */
	@EJB
    private UtilisateurDao   utilisateurDao;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet d'afficher la page de formulaire à remplir pour creer un utilisateur en cas de requete de type GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_CREATION).forward( request, response );
	}

	/**
	 * Permet de creer un utilisateur et d'afficher la page de de synthese utilisateur en cas de succes et pour une requete de type POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
		creationUtilisateurForm utilForm = new creationUtilisateurForm(utilisateurDao);
		Utilisateur util=utilForm.CreerUtilisateur(request);
		String message=utilForm.getMessage();
		boolean erreur=utilForm.getErreur();
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_UTILISATEUR,util );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
