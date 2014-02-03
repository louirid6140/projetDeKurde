package beans;

import java.util.ArrayList;

public class Anomalie {
	private String sujet;
	private String	description;
	private String etat;
	private String nomUtilisateurAff;
	private ArrayList<String> notes = new ArrayList<String>();
	

	
	
	
	public Anomalie() {
		super();
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
	public String getNomUtilisateurAff() {
		return nomUtilisateurAff;
	}
	public void setNomtUtilisateurAff(String nomUtilisateurAff) {
		this.nomUtilisateurAff = nomUtilisateurAff;
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
