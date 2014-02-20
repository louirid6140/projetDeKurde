package beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <b>Projet est la classe representant un projet informatique. C'est une classe bean.</b>
 * <p>
 *  Un projet est caracterise par:
 * <ul>
 * <li>un nom ( le nom du projet )</li>
 * <li>des caracteristiques ( differentes caracteristiques du projet  )</li>
 * </ul>
 * </p>
 */



@Entity
@XmlRootElement(name="Projet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Projet {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id_projet;
	
	/**
	 * nomProjet correspond au nom du projet
	 * e.g "Project Manager"
	 * 
	 */
	@XmlElement(name="nomProjet")
	private String nomProjet ; 

	/**
	 *caracProjet correspond au differentes caracteristiques du projet
	 * e.g "Echeances, nombre de personnes"
	 * 
	 */
	private String caracProjet;
	
	@XmlElementWrapper(name="Anomalies")
	@XmlElement(name="Anomalie")
	@OneToMany
	private List<Anomalie> listeAnomalie;
	




	/**
	 * Constructeur d'un projet
	 */
	public Projet() {
		super();
	}


	public Projet(String nomProjet, String caracProjet) {
		super();
		this.nomProjet = nomProjet;
		this.caracProjet = caracProjet;
	}


	/**
	 * Retourne les caracteristiques du projet
	 * 
	 * @return caracteristiques projet.
	 */
	public String getCaracProjet() {
		return caracProjet;
	}

	/**
	 * Met a jour les caracteristiques du projet.
	 * 
	 * @param caracProjet
	 * 
	 */
	public void setCaracProjet(String caracProjet) {
		this.caracProjet = caracProjet;
	}

	/**
	 * Retourne le nom du projet
	 * 
	 * @return nom projet.
	 */
	public String getNomProjet() {
		return nomProjet;
	} 

	/**
	 * Met a jour le nom du projet.
	 * 
	 * @param nomProjet
	 * 
	 */
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	
	public List<Anomalie> getListeAnomalie() {
		return listeAnomalie;
	}


	public void setListeAnomalie(List<Anomalie> listeAnomalie) {
		this.listeAnomalie = listeAnomalie;
	}
	
}
