package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;

/**
 * Servlet implementation class CreationUtilisateur
 */
@WebServlet("/CreationUtilisateur")
public class CreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_NOM   = "nomUtilisateur";
	public static final String CHAMP_PRENOM   = "prenomUtilisateur";
	public static final String CHAMP_MAIL   = "emailUtilisateur";
	public static final String CHAMP_LOGIN   = "loginUtilisateur";
	public static final String CHAMP_PASSWORD   = "passwordUtilisateur";
	
	public static final String ATT_UTILISATEUR     = "utilisateur";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";

	public static final String VUE             ="/WEB-INF/utilisateurCree.jsp";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter( CHAMP_NOM );
		String prenom = request.getParameter( CHAMP_PRENOM );
		String adresse = request.getParameter( CHAMP_MAIL );
		String login = request.getParameter( CHAMP_LOGIN );
		String password = request.getParameter( CHAMP_PASSWORD );
		String message;
		boolean erreur;

		/*
		 * Initialisation du message � afficher : si un des champs
		        obligatoires* du formulaire n'est pas renseign�, alors on affiche un message
		 * d'erreur, sinon on affiche un message de succ�s
		 */
		if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ||
				adresse.trim().isEmpty() ||login.trim().isEmpty() ||password.trim().isEmpty() ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerUtilisateur.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un utilisateur.";
			erreur = true;
		} else {
			message = "Utilisateur cr�� avec succ�s !";
			erreur = false;
		}

		/*
		 * Cr�ation du bean Client et initialisation avec les donn�es r�cup�r�es
		 */
		Utilisateur util = new Utilisateur();
		util.setNom( nom );
		util.setPrenom( prenom );
		util.setEmail( adresse );
		util.setLogin( login );
		util.setPassword( password);
		
		/* Ajout du bean et du message � l'objet requ�te */
		request.setAttribute( ATT_UTILISATEUR,util );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );
		/* Transmission � la page JSP en charge de l'affichage des donn�es */
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

}
