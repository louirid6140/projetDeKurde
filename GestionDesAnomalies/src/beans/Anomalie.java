package beans;

import java.util.ArrayList;
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
public class Anomalie {
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
     *etat correspond l'avancement de la resolution de l'anomalie
     * e.g "RESOLUE"
     * 
     */
	
	private String etat;
	
    /**
     *nomUtilisateurAff correspond au nom de l'utilisateur qui est affecte a la resolution de l'anomalie
     * e.g "Loir-Mongazon"
     * 
     */
	private String nomUtilisateurAff;
	
    /**
     *notes correspond au notes saisies par l'utilisateur au cours de la tache
     * e.g "tests effectués"
     * 
     */
	private ArrayList<String> notes = new ArrayList<String>();
	
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
     * Retourne la liste des notes sur l'anomalie
     * 
     * @return notes.
     */
	public ArrayList<String> getNotes() {
		return notes;
	}
	
    /**
     * Ajouter une note à la liste des notes de l'anomalie
     * 
     * @param nouvelleNote
     * 
     */
	public ArrayList<String> ajouterNote(String nouvelleNote){
		notes.add(nouvelleNote);
		return notes;
	}
	
	
	
}
