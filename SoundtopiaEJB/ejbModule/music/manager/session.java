package music.manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.User;

/**
 * Session Bean implementation class session
 */
@Stateless
public class session implements sessionRemote, sessionLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public session() {
        // TODO Auto-generated constructor stub
    }
    
    public User getUser(int id) {
    	return em.find(User.class, id);
    }

}
