package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Administrateur;



@Stateless
public class AdministrateurDao {
    private static final String JPQL_SELECT_PAR_LOGIN = "SELECT u FROM Administrateur u WHERE u.login=:login";
    private static final String PARAM_LOGIN           = "login";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_sdzee_PU" )
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Administrateur admin ) throws DAOException {
        try {
            em.persist( admin );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Administrateur trouver( String login ) throws DAOException {
    	Administrateur admin = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_LOGIN );
        requete.setParameter( PARAM_LOGIN, login );
        try {
        	admin = (Administrateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return admin;
    }
}