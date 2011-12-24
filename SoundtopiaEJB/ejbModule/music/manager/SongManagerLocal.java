package music.manager;

import javax.ejb.Local;

import music.data.SongAdditionVO;
import music.data.SongVO;

@Local
public interface SongManagerLocal {
	public void rateASong(int userID, int songID, int rating);

	public float getMeanRate(int songID);

	public SongAdditionVO getSongInformation(int songID);

	public SongVO changeSongInformation(int songID, String interpreter,
			String title, String cover);

	public SongVO getSong(int songID);

	public SongVO undoChanges(int songID);

	public void readNewSongInformationFromAPIs(int songID, String interpreter,
			String title);
}
