package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Projet;

@Stateless
public class ProjetDao {
    private static final String JPQL_SELECT_PAR_NOM = "SELECT u FROM Projet u WHERE u.nom=:nom";
    private static final String PARAM_NOM           = "nom";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_sdzee_PU" )
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Projet projet ) throws DAOException {
        try {
            em.persist( projet );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Projet trouver( String nom ) throws DAOException {
        Projet projet = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_NOM );
        requete.setParameter( PARAM_NOM, projet );
        try {
            projet = (Projet) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return projet;
    }
}