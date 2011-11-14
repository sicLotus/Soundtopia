package music.manager;
import javax.ejb.Local;

import music.data.Song;
import music.data.User;

@Local
public interface SessionLocal {
	public Song getSong(int id);
}
