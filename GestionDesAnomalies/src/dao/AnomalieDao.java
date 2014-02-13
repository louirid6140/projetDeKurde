package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Anomalie;

@Stateless
public class AnomalieDao {
    private static final String JPQL_SELECT_PAR_ID = "SELECT u FROM Anomalie u WHERE u.id_anom=:id_anom";
    private static final String PARAM_ID          = "id";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_sdzee_PU" )
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Anomalie anom ) throws DAOException {
        try {
            em.persist( anom );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Anomalie trouver( String id ) throws DAOException {
        Anomalie anom = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_ID );
        requete.setParameter( PARAM_ID, id );
        try {
        	anom = (Anomalie) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return anom;
    }
}