package music.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Song;
import music.data.User;
import music.repository.UserDAO;

/**
 * Session Bean implementation class session
 */
@Stateless
public class Session implements SessionRemote, SessionLocal {
	@PersistenceContext
	private EntityManager em;
    
	@EJB
	private UserDAO userDAO;
	
	
    public Session() {
        // TODO Auto-generated constructor stub
    }
    
  
    
    public Song getSong(int id) {
    	return em.find(Song.class, id);
    }
    

    
    /*public Lyric getLyric(int id) {
    	return em.find(Lyric.class, id);
    }*/

}
