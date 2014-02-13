package dao;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Utilisateur;

@Stateless
public class UtilisateurDao {
	private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	private static final String JPQL_SELECT_PAR_ID = "SELECT u FROM Utilisateur u WHERE u.id_util=:id_util";
	private static final String PARAM_EMAIL           = "email";
	private static final String PARAM_ID           = "id_util";

	// Injection du manager, qui s'occupe de la connexion avec la BDD
	@PersistenceContext( unitName = "bdd_sdzee_PU" )
	private EntityManager em;

	/**
	 * Enregistrement d'un nouvel utilisateur
	 * @param utilisateur
	 * @throws DAOException
	 */
	public void creer( Utilisateur utilisateur ) throws DAOException {
		try {
			em.persist( utilisateur );
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
	}

	/**
	 *  Recherche d'un utilisateur à partir de son adresse email
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	public Utilisateur trouver( String email ) throws DAOException {
		Utilisateur utilisateur = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
		requete.setParameter( PARAM_EMAIL, email );
		try {
			utilisateur = (Utilisateur) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return utilisateur;
	}

	/**
	 * Retrouve un utilisateur à partir de son identifiant
	 * @param id
	 * @return l'utilisateur
	 * @throws DAOException
	 */
	public Utilisateur trouverParId(int id) throws DAOException {
		Utilisateur utilisateur = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_ID );
		requete.setParameter( PARAM_ID, id );
		try {
			utilisateur = (Utilisateur) requete.getSingleResult();
		} catch ( NoResultException e ) {
			return null;
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return utilisateur;
	}


	/**
	 *  
	 * @return La liste de tous les utilisateurs de la base de données
	 */
	@SuppressWarnings("unchecked")
	public List<Utilisateur> trouverTous(){
		List<Utilisateur> al = new ArrayList<Utilisateur>();
		Query requete = em.createQuery( "SELECT u FROM Utilisateur u" );
		try {
			al = requete.getResultList();
		} catch ( NoResultException e ) {
		} catch ( Exception e ) {
			throw new DAOException( e );
		}
		return al;
	}
}
