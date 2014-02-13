package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisateurDao;
/**
 * <b>creationUtilisateurForm est la classe representant le formulaire de creation d'un utilisateur. C'est une classe formulaire.</b>
 * <p>
 *  Cette classe est caracterisee par:
 * <ul>
 * <li>message da confirmation ou d'errreur</li>
 * <li>l'erreur de la creation (si un des champs n'est pas renseigne)</li>
 * </ul>
 * </p>
 */
public class creationUtilisateurForm {
	/**
	 * CHAMP_NOM     constante correspondant au champ du  nom de l utilisateur
	 */
	private static final String CHAMP_NOM   = "nomUtilisateur";
	/**
	 * CHAMP_PRENOM  constante correspondant au champ du  prenom de l utilisateur
	 */
	private static final String CHAMP_PRENOM   = "prenomUtilisateur";
	/**
	 * CHAMP_MAIL    constante correspondant au champ de l email de l utilisateur
	 */
	private static final String CHAMP_MAIL   = "emailUtilisateur";
	/**
	 * CHAMP_LOGIN   constante correspondant au champ du  login de l utilisateur
	 */
	private static final String CHAMP_LOGIN   = "loginUtilisateur";
	/**
	 * CHAMP_PASSWORD   constante correspondant au champ du  mot de passe de l utilisateur
	 */
	private static final String CHAMP_PASSWORD   = "passwordUtilisateur";

	/**
	 *message correspond au resultat de la creation en chaine de caractere
	 * e.g "creation reussie"
	 * 
	 */
	private String message;

	/**
	 *erreur correspond a un booleen vrai si il y a une erreur de creation faux sinon
	 * 
	 */
	private Boolean erreur;

	private Map<String, String> erreurs = new HashMap<String, String>();
	private UtilisateurDao utilisateurDao;
	
	public creationUtilisateurForm( UtilisateurDao utilisateurDao ) {
        this.utilisateurDao = utilisateurDao;
    }


	/**
	 * Retourne le resultat de la creation
	 * 
	 * @return resultat creation.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Retourne si il y a eu une erreur de creation ou non
	 * 
	 * @return erreur creation.
	 */
	public Boolean getErreur() {
		return erreur;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	/**
	 * Retourne un utilisateur en fonction des champs renseignes et
	 * determine le resultat de la creation en fonction des champs renseignes
	 * @return Utilisateur
	 */
	public Utilisateur CreerUtilisateur(HttpServletRequest request) {
		String nom = getValeurChamp( request, CHAMP_NOM );
		String prenom = getValeurChamp( request, CHAMP_PRENOM );
		String adresse = getValeurChamp( request, CHAMP_MAIL  );
		String login = getValeurChamp( request, CHAMP_LOGIN);
		String password = getValeurChamp( request, CHAMP_PASSWORD  );
		Utilisateur util = new Utilisateur();
		util.setNom( nom );
		util.setPrenom( prenom );
		util.setEmail( adresse );
		util.setLogin( login );
		util.setPassword( password);
		

		if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ||
				adresse.trim().isEmpty() ||login.trim().isEmpty() ||password.trim().isEmpty() ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerUtilisateur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un utilisateur.";
			erreur = true;
		} else {
			utilisateurDao.creer( util );
			message = "Utilisateur créé avec succès !";
			erreur = false;
		}		
		return(util);
	}

	/**
	 * Methode qui recupere la valeur des champs renseignes
	 * @param request
	 * @param nomChamp
	 */
	private static String getValeurChamp( HttpServletRequest
			request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );

		if ( valeur == null || valeur.trim().length() == 0 ) {
			return "";
		} else {
			return valeur;
		}
	}

}

