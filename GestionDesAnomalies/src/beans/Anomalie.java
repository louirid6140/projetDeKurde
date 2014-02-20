package beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * <b>Anomalie est la classe representant une anomalie sur un projet. C'est une classe bean.</b>
 * <p>
 *  Une anomalie est caracterisee par:
 * <ul>
 * <li>un sujet ( description courte de l'anomalie )</li>
 * <li>une description ( description plus longue de l'anomalie )</li>
 * <li>un etat (etat d'avancement de la resolution de l'anomalie)</li>
 * <li>un nom d'utilisateur (utilisateur charge de resoudre l'anomalie)</li>
 * <li>une liste de notes (permettant de commenter l'avancement de la resolution)</li>
 * </ul>
 * </p>
 */

@Entity
public class Anomalie {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id_anomalie;

	public int getId_anomalie() {
		return id_anomalie;
	}


	public void setId_anomalie(int id_anomalie) {
		this.id_anomalie = id_anomalie;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 *sujet correspond a une courte description de l'anomalie
	 * e.g "bug incrementation des indices"
	 * 
	 */
	private String sujet;

	/**
	 *description correspond a une description plus developpee de l'anomalie
	 * e.g "l'incrementation des indices ne se fait pas correctement. Explications..."
	 * 
	 */


	private String	description;

	/**
	 * etat correspond l'avancement de la resolution de l'anomalie
	 * e.g "RESOLUE"
	 * 
	 */

	private String etat;

	/**
	 * nomUtilisateurAff correspond au nom de l'utilisateur qui est affecte a la resolution de l'anomalie
	 * e.g "Loir-Mongazon"
	 * 
	 */
	private String nomUtilisateurAff;

	/**
	 * nomProjetAff correspond au nom du projet qui est affecte à l'anomalie
	 */
	private String nomProjetAff;

	/**
	 *notes correspond au notes saisies par l'utilisateur au cours de la tache
	 * e.g "tests effectués"
	 * 
	 */
	private String notes;
	
	/**
	 * Booléen qui sera passé à true lorsque l'anomalie sera affectée à un utilisateur
	 */
	private boolean affecte=false;

	@ManyToOne
	private Projet projet;

	@ManyToOne
	private Utilisateur utilisateur;




	/**
	 * Constructeur d'un anomalie
	 */
	public Anomalie() {
		super();
	}


	/**
	 * Retourne le sujet de l'anomalie
	 * 
	 * @return sujet anomalie.
	 */

	public String getSujet() {
		return sujet;
	}

	/**
	 * Met a jour le sujet de l'anomalie.
	 * 
	 * @param sujet
	 * 
	 */
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	/**
	 * Retourne la description longue de l'anomalie
	 * 
	 * @return description anomalie.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Met a jour le descritpion de l'anomalie.
	 * 
	 * @param description
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Retourne l etat d avancement de l anomalie
	 * 
	 * @return etat avancement.
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * Met a jour l'etat de l'anomalie.
	 * 
	 * @param etat
	 * 
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	/**
	 * Retourne le nom de l'utilisateur affecte a l'anomalie
	 * 
	 * @return nom utilisateur affecte.
	 */
	public String getNomUtilisateurAff() {
		return nomUtilisateurAff;

	}

	/**
	 * Met a jour le nom de l'utilisateur affecte.
	 * 
	 * @param nomUtilisateurAff
	 * 
	 */
	public void setNomtUtilisateurAff(String nomUtilisateurAff) {
		this.nomUtilisateurAff = nomUtilisateurAff;
	}
	
	/**
	 * 
	 * @return Le nom du projet affecté
	 */
	public String getNomProjetAff() {
		return nomProjetAff;
	}

	/**
	 * Modifie le nom du projet affecté
	 * @param nomProjetAff
	 */
	public void setNomProjetAff(String nomProjetAff) {
		this.nomProjetAff = nomProjetAff;
	}

	/**
	 * Retourne la liste des notes sur l'anomalie
	 * 
	 * @return notes.
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Ajouter une note à la liste des notes de l'anomalie
	 * 
	 * @param nouvelleNote
	 * 
	 */
	public void ajouterNote(String nouvelleNote){
		notes= nouvelleNote;
	}
	
	/**
	 * Getter de affectée
	 * @return
	 */
	public boolean isAffecte() {
		return affecte;
	}

	/**
	 * Setter de affecte
	 * @param affecte
	 */
	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}

	/**
	 * Getter pour le projet
	 * @return le projet
	 */
	public Projet getProjet() {
		return projet;
	}

	/**
	 * Setter pour le projet
	 * @param projet
	 */
	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	/**
	 * Getter pour l'utilisateur
	 * @return l'utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * Setter pout l'utilisateur
	 * @param utilisateur
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


}
