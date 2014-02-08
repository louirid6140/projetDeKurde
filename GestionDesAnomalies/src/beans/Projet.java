package beans;

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
public class Projet {
	
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
	private String caracProjet;
	
    /**
     * Constructeur d'un projet
     */
	public Projet() {
		super();
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
