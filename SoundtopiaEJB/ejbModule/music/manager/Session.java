package music.manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Song;
import music.data.User;

/**
 * Session Bean implementation class session
 */
@Stateless
public class Session implements SessionRemote, SessionLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Session() {
        // TODO Auto-generated constructor stub
    }
    
    public User getUser(int id) {
    	return em.find(User.class, id);
    }
    
    public Song getSong(int id) {
    	return em.find(Song.class, id);
    }
    
    /*public Lyric getLyric(int id) {
    	return em.find(Lyric.class, id);
    }*/

}
