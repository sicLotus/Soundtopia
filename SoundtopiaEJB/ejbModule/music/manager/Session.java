package music.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Song;
import music.repository.UserDAO;
import music.services.MyVideoAPI;

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
    
    public void myvideotest() {
    	MyVideoAPI api = new MyVideoAPI();
    	api.retrieveData();
    }
    

    
    /*public Lyric getLyric(int id) {
    	return em.find(Lyric.class, id);
    }*/

}
