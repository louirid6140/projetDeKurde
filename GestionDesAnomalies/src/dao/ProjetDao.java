package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Projet;
/**
 * <b>ProjetDAO permet d'enregistrer les projets dans notre base de donnees. C'est une classe DAO.</b>
 */
@Stateless
public class ProjetDao {
	private static final String JPQL_SELECT_PAR_NOM = "SELECT u FROM Projet u WHERE u.nomProjet=:nomProjet";
	private static final String PARAM_NOM           = "nomProjet";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "bdd_sdzee_PU" )
	private EntityManager em;

	/**
	 *  Fonction qui permet de creer un projet en base de donnees
	 * @param projet
	 * @throws DAOException
	 */
	public void creer( Projet projet ) throws DAOException {
		try {
			em.persist( projet );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
	}

	/**
	 *  Permet de chercher un projet par son nom
	 * @param nom
	 * @throws DAOException
	 * @return Un projet qui a le nom demandé
	 */
	public Projet trouver( String nom ) throws DAOException {
		Projet projet = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
		requete.setParameter( PARAM_NOM, nom );
		try {
			projet = (Projet) requete.getSingleResult();
		//	projet = em.find(Projet.class, nom);
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return projet;
	}

	/**
	 * Permet de retourner la liste de tous les projets
	 * @return La liste de tous les projets de la base de données
	 */
	@SuppressWarnings("unchecked")
	public List<Projet> trouverTous(){
		List<Projet> al = new ArrayList<Projet>();
		Query requete = em.createQuery( "SELECT u FROM Projet u" );
		try {
			al = requete.getResultList();
		} catch ( NoResultException e ) {
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return al;
	}
	
	/**
	 *  Permet de modififier un projet	 
	 * @param projetAmodif
	 * @param recup
	 * @throws DAOException
	 * @return Projet modifié
	 */
	public Projet modifierProjet(Projet projetAmodif,Projet recup){
		
		projetAmodif.setNomProjet(recup.getNomProjet());
		projetAmodif.setCaracProjet(recup.getCaracProjet());

		try {

			em.merge(projetAmodif);
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return (projetAmodif);
	}
}
