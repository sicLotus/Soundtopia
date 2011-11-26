package music.manager;
import javax.ejb.Local;

import music.data.Song;

@Local
public interface SessionLocal {
	public Song getSong(int id);
	public void readChartsFromMyvideo();
}
