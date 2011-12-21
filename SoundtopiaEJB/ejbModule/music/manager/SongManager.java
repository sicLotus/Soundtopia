package music.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.Song;
import music.repository.RatingDAO;
import music.repository.SongDAO;

/**
 * Session Bean implementation class SongManager
 */
@Stateless
public class SongManager implements SongManagerRemote, SongManagerLocal {

	@EJB
	private RatingDAO ratingDAO;
	
	@EJB
	private SongDAO songDAO;
	
    /**
     * Default constructor. 
     */
    public SongManager() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 
     * @return Durchschnittsbewertung eines Songs
     * geht nicht, da der trigger scheinbar zu langsam ist oO
     */
    public void rateASong(int userID, int songID, int rating) {
    	ratingDAO.createRating(userID, songID, rating);
    	//Song song = songDAO.findSong(songID);
    	//return song.getRating();
    }
    
    public float getMeanRate(int songID) {
    	Song song = songDAO.findSong(songID);
    	return song.getRating(); 
    }

}
