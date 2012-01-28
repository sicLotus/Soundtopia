package music.manager;

import javax.ejb.Local;

import music.data.ValueObject.SongAdditionVO;
import music.data.ValueObject.SongVO;

@Local
public interface SongManagerLocal {
	public void rateASong(int userID, int songID, int rating);
	public float getMeanRate(int songID);
	public SongAdditionVO getSongInformation(int songID);
	public SongVO changeSongInformation(int songID, SongVO song);
	public SongVO getSong(int songID);
	public SongVO undoChanges(int songID);
	public int getVoteCount(int songID);
	public String getPictureFromAmazon(String interpreter, String title);
	public String getPictureFromGoogle(String interpreter, String title, int index);
	public void readNewSongInformationFromAPIs(int songID, String interpreter, String title);
}
