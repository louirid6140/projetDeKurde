package dao;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Utilisateur;
/**
 * <b>UtilisateurDAO permet d'enregistrer les utilisateurs dans notre base de donnees. C'est une classe DAO.</b>
 */
@Stateless
public class UtilisateurDao {
	private static final String JPQL_SELECT_PAR_LOGIN = "SELECT u FROM Utilisateur u WHERE u.login=:login";
	private static final String PARAM_LOGIN           = "login";


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
	 *  Recherche d'un utilisateur à partir de son login
	 * @param email
	 * @return
	 * @throws DAOException
	 */
	public Utilisateur trouver( String login ) throws DAOException {
		Utilisateur utilisateur = null;
		Query requete = em.createQuery( JPQL_SELECT_PAR_LOGIN );
		requete.setParameter( PARAM_LOGIN, login );
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
	 *  Permet de retourner la liste de tous les utilisateurs de la bdd
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
