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
		 * Initialisation du message à afficher : si un des champs
		        obligatoires* du formulaire n'est pas renseigné, alors on affiche un message
		 * d'erreur, sinon on affiche un message de succès
		 */
		if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ||
				adresse.trim().isEmpty() ||login.trim().isEmpty() ||password.trim().isEmpty() ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerUtilisateur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un utilisateur.";
			erreur = true;
		} else {
			message = "Utilisateur créé avec succès !";
			erreur = false;
		}

		/*
		 * Création du bean Client et initialisation avec les données récupérées
		 */
		Utilisateur util = new Utilisateur();
		util.setNom( nom );
		util.setPrenom( prenom );
		util.setEmail( adresse );
		util.setLogin( login );
		util.setPassword( password);
		
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_UTILISATEUR,util );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );
		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

}
