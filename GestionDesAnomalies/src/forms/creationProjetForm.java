package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Projet;
import dao.ProjetDao;

/**
 * <b>creationProjetForm est la classe representant le formulaire de creation d'une projet. C'est une classe formulaire.</b>
 * <p>
 *  Cette classe est caracterisee par:
 * <ul>
 * <li>message da confirmation ou d'errreur</li>
 * <li>l'erreur de la creation (si un des champs n'est pas renseigne)</li>
 * </ul>
 * </p>
 */
public class creationProjetForm {

	/**
	 * CHAMP_NOM_PROJET   constante correspondant au nom du projet
	 */
	private static final String CHAMP_NOM_PROJET   = "nomProjet";
	/**
	 * CHAMP_CARAC_PROJET   constante correspondant aux caracteristiques du projet
	 */
	private static final String CHAMP_CARAC_PROJET  = "caracProjet";
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
	private ProjetDao projetDao;

	public creationProjetForm( ProjetDao projetDao ) {
		this.projetDao = projetDao;
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
	 * Retourne un projet en fonction des champs renseignes et
	 * determine le resultat de la creation en fonction des champs renseignes
	 * @return Projet
	 */
	public Projet CreerProjet(HttpServletRequest request) {
		String nomProjet = getValeurChamp( request, CHAMP_NOM_PROJET );
		String caracProjet = getValeurChamp( request, CHAMP_CARAC_PROJET );

		Projet proj = new Projet();
		proj.setNomProjet(nomProjet);
		proj.setCaracProjet(caracProjet);

		if ( nomProjet.trim().isEmpty() || caracProjet.trim().isEmpty()  ) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"projets\">Cliquez ici</a> pour accéder au formulaire de création d'un projet.";
			erreur = true;
		} else {
			//projetDao.creer( proj );
			message = "Projet créé ou modifié avec succès !";
			erreur = false;

		}

		return(proj);
	}

	/**
	 * Methode qui recupere la valeur des champs renseignes
	 * @param request
	 * @param nomChamp
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return "";
		} else {
			return valeur;
		}
	}
}
