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
 * <b>AjouterUnProjet est une servlet permettant d'ajouter un PROJET. C'est une servlet ( qu on peut assimiler à un controleur). 
 * Elle demande au metier de faire des actions recupere les informations et demande à la vue de les afficheer.</b>
 */
@WebServlet("/AjouterUnProjet")


public class AjouterUnProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ATT_ANOMALIE   constante donnant un nom a l attribut projet
	 */
	public static final String ATT_PROJET     = "projet";

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
	public static final String VUE_SUCCES             ="/WEB-INF/projetCree.jsp";


	/**
	 * VUE_FORMULAIRE_ANOMALIE    constante donnant l url de la page à afficher pour creer un projet
	 */


	public static final String VUE_FORMULAIRE_PROJET        ="/WEB-INF/ajouterProjet.jsp";

	/**
	 * On injecte l'EJB
	 */
	@EJB
	private ProjetDao   projetDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterUnProjet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet d'afficher la page de formulaire à remplir pour creer un projet en cas de requete de type GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_PROJET).forward( request, response );
	}

	/**
	 * Permet de creer un projet et d'afficher la page de de synthese de projet en cas de succes et pour une requete de type POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creationProjetForm projForm = new creationProjetForm(projetDao);
		Projet proj=projForm.CreerProjet(request);
		String message=projForm.getMessage();
		boolean erreur=projForm.getErreur();

		try{
			Projet pr = projetDao.trouver(proj.getNomProjet());
			erreur=true;
			message="Le nom de projet "+pr.getNomProjet()+" est déjà utilisé <br> <a href=\"projets\">Cliquez ici</a> pour revenir au formulaire de création d'un projet.";
		}catch(Exception e){
			projetDao.creer( proj );
		}

		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_PROJET,proj );
		request.setAttribute( ATT_MESSAGE, message );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
