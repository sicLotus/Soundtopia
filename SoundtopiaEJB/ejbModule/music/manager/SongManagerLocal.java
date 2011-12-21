package music.manager;
import javax.ejb.Local;

@Local
public interface SongManagerLocal {
	public void rateASong(int userID, int songID, int rating);
	public float getMeanRate(int songID);
}
