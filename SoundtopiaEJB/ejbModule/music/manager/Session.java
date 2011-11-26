package music.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.ChartEntryVO;
import music.data.Song;
import music.repository.SongDAO;
import music.services.GoogleImageAPI;
import music.services.MyVideoAPI;

/**
 * Session Bean implementation class session
 */
@Stateless
public class Session implements SessionRemote, SessionLocal {
	@PersistenceContext
	private EntityManager em;
    
	@EJB
	private SongDAO songDAO;
	
	
    public Session() {
    }
    
  
    
    public Song getSong(int id) {
    	return em.find(Song.class, id);
    }
    
    public void readChartsFromMyvideo() {
    	MyVideoAPI api = new MyVideoAPI();
    	ChartEntryVO entry;
    	List<ChartEntryVO> chartList = api.retrieveData();
    	System.out.println("Succeeded: "+chartList.size());
    	for(int i = 0; i < chartList.size(); i++) {
    		entry = chartList.get(i);
    		songDAO.createSong(entry.getInterpreter(), entry.getTitle(), entry.getMovie_length(), entry.getMovie_url());
    		addPicture(entry.getInterpreter(), entry.getTitle());
    	}
    }
    
    public void addPicture(String interpreter, String title) {
    	String picture = GoogleImageAPI.retrieveData(interpreter, title);
    	Song s = songDAO.findSong(interpreter, title);
    	if (s != null)
    		songDAO.addPicture(s.getId(), picture);
    }
    

}
