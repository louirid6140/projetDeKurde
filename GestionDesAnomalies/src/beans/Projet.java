package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id_projet; 

	/**
	 * nomProjet correspond au nom du projet
	 * e.g "Project Manager"
	 * 
	 */
	private String nomProjet ; 

	/**
	 *caracProjet correspond au differentes caracteristiques du projet
	 * e.g "Echeances, nombre de personnes"
	 * 
	 */
	@Column( name = "caracProjet" )
	private String caracProjet;

	/**
	 * Constructeur d'un projet
	 */
	public Projet() {
		super();
	}

	/**
	 * @return l'identifiant du projet
	 */
	public Long getId_projet() {
		return id_projet;
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


}
