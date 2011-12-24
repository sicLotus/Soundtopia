package music.manager;
import javax.ejb.Local;

import music.data.Song;

@Local
public interface SessionLocal {
	public Song getSong(int id);
	public void readChartsFromMyvideo();
	public String getPictureFromAmazon(String interpreter, String title);
	public String getPictureFromGoogle(String interpreter, String title);
}
