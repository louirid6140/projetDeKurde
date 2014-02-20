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

import beans.Anomalie;
import beans.Utilisateur;
import dao.AnomalieDao;
import dao.UtilisateurDao;
import forms.AffectationUtilisateurForm;

/**
 * Servlet implementation class AffectationAnomalie
 */
@WebServlet("/AffectationAnomalie")
public class AffectationAnomalie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_UTILISATEUR   = "util";
	public static final String ATT_ANOMALIE    = "ano";
	public static final String ATT_MESSAGE     = "message";
	public static final String ATT_ERREUR      = "erreur";
	
	public static final String VUE_SUCCES             ="/WEB-INF/affectationConfirmee.jsp";
	
	public static final String VUE_FORMULAIRE_AFFECTATION        ="/WEB-INF/affectationUtilisateur.jsp";
       
	/**
	 * On injecte l'EJB
	 */
	@EJB
	private AnomalieDao   anomalieDao;
	@EJB
	private UtilisateurDao utilisateurDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffectationAnomalie() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* On crée la liste des anomalies */
		List<Anomalie> al = anomalieDao.trouverTous();
		List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
		for(int i=0; i<=al.size()-1; i++){
			Map<String, String> anom = new HashMap<String, String>();
			anom.put("sujet", al.get(i).getSujet());
			liste.add(anom);
		}		
		request.setAttribute( "liste", liste );
		
		/* On crée la liste des anomalies */
		List<Utilisateur> al2 = utilisateurDao.trouverTous();
		List<Map<String, String>> liste2 = new ArrayList<Map<String, String>>();
		for(int i=0; i<=al2.size()-1; i++){
			Map<String, String> util = new HashMap<String, String>();
			util.put("login", al2.get(i).getLogin());
			liste2.add(util);
		}		
		request.setAttribute( "liste2", liste2 );
		
		 this.getServletContext().getRequestDispatcher(VUE_FORMULAIRE_AFFECTATION ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AffectationUtilisateurForm affect = new AffectationUtilisateurForm(anomalieDao, utilisateurDao);
		Anomalie anom = affect.affectationAnomalie(request);
		Utilisateur ut = anom.getUtilisateur();
		try{

			Anomalie a = anomalieDao.modifierUtilisateur(anom, ut);
			anomalieDao.creer(a);


		}catch(Exception e){
			System.out.println("catch");
		}
		
		
		String util = affect.getChamp1();
		String ano = affect.getChamp2();
		String messag=affect.getResultat();
		boolean erreur=affect.getErreur();
		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute( ATT_ANOMALIE,ano);
		request.setAttribute( ATT_UTILISATEUR,util);
		request.setAttribute( ATT_MESSAGE, messag );
		request.setAttribute( ATT_ERREUR, erreur );

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher(VUE_SUCCES).forward( request, response );
	}

}
