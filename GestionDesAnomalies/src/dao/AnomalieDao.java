package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Anomalie;
import beans.Utilisateur;
/**
 * <b>Anomalie DAO permet d'enregistrer les anomalies dans notre base de donnees. C'est une classe DAO.</b>
 */

@Stateless

public class AnomalieDao {
	private static final String JPQL_SELECT_PAR_SUJET = "SELECT u FROM Anomalie u WHERE u.sujet=:sujet";
	private static final String PARAM_SUJET          = "sujet";    
	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "bdd_sdzee_PU" )
	private EntityManager em;

	//  private EntityTransaction transac = em.getTransaction();


	/**
	 *  Fonction qui permet de creer une anomalie en base de donnees
	 * @param anom
	 * @throws DAOException 
	 */
	public void creer( Anomalie anom ) throws DAOException {
		try {
			em.persist( anom );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
	}

	/**
	 *  Fonction qui permet de trouver toutes les anomalies en fonction du sujet
	 * @param sujet
	 * @throws DAOException
	 * @return La liste de toutes les anomalies en fonction du sujet de la base de données
	 */
	public Anomalie trouver( String sujet ) throws DAOException {
		Anomalie anom = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_SUJET );
		requete.setParameter( PARAM_SUJET, sujet );
		try {
			anom = (Anomalie) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return anom;
	}

	/**
	 *  Fonction qui permet de trouver toutes les anomalies
	 * @return La liste de toutes les anomalies de la base de données
	 */
	@SuppressWarnings("unchecked")
	public List<Anomalie> trouverTous(){
		List<Anomalie> al = new ArrayList<Anomalie>();
		Query requete = em.createQuery( "SELECT u FROM Anomalie u" );
		try {
			al = requete.getResultList();
		} catch ( NoResultException e ) {
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return al;
	}

	/**
	 *  Fonction qui permet de modifier une anomalie
	 * @param anoAmodif
	 * @param anoRecup
	 * @return L'anomalie modifiee
	 */
	public Anomalie modifierAnomalie(Anomalie anoAmodif,Anomalie anoRecup){

		anoAmodif.setSujet(anoRecup.getSujet());
		anoAmodif.setDescription(anoRecup.getDescription());
		anoAmodif.setNotes(anoRecup.getNotes());

		try {
			em.merge(anoAmodif);
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return (anoAmodif);
	}

	/**
	 *  Fonction qui permet de mettre a jour une anomalie en base
	 * @param anoAmodif
	 * @param anoRecup
	 * @return L'anomalie mise a jour
	 */
	public Anomalie MajAnomalie(Anomalie anoAmodif,Anomalie anoRecup){

		anoAmodif.setEtat(anoRecup.getEtat());
		try {
			em.merge(anoAmodif);
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return (anoAmodif);
	}

	/**
	 *  Fonction qui permet de modifier d'affecter une anomalie a un utilisateur en base
	 * @param anoAmodif
	 * @param ut
	 * @return L'anomalie modifiee
	 */
	public Anomalie modifierUtilisateur(Anomalie anom, Utilisateur ut){
		String sujet_old=anom.getSujet();
		anom.setUtilisateur(ut);
		Anomalie new_anom = this.trouver(sujet_old);
		Query requete = em.createQuery("DELETE FROM Anomalie u WHERE u.sujet=:sujet");
		requete.setParameter("sujet", sujet_old);
		try {
			requete.executeUpdate();
			//em.persist(anom);
		} catch ( Exception e ) {
			throw new DAOException( e );
		}

		new_anom.setUtilisateur(ut);
		new_anom.setAffecte(true);
		new_anom.setNomtUtilisateurAff(ut.getNom());;
		new_anom.setEtat("AFFECTEE");
		return (new_anom);
	}


}