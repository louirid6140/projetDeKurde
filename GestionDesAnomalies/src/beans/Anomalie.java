package beans;

import java.util.ArrayList;

public class Anomalie {
	private String sujet;
	private String	description; // Attention , il faudra vérifier que la taille est inférieure à 255 caract
	private String etat;
	private Utilisateur utilisateurAff;
	private ArrayList<String> notes;
	
	private ArrayList<String> listeDesEtats; 

	
	
	
	public Anomalie() {
		super();
		listeDesEtats.add("NOUVEAU");
		listeDesEtats.add("AFFECTEE");
		listeDesEtats.add("RESOLUE");
		listeDesEtats.add("FERMEE");
	}
	//Getters and setters utiles
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Utilisateur getUtilisateurAff() {
		return utilisateurAff;
	}
	public void setUtilisateurAff(Utilisateur utilisateurAff) {
		this.utilisateurAff = utilisateurAff;
	}
	public ArrayList<String> getNotes() {
		return notes;
	}
	
	//Methode permettant d'ajouter une note
	public ArrayList<String> ajouterNote(String nouvelleNote){
		notes.add(nouvelleNote);
		return notes;
	}
	
	
	
}
