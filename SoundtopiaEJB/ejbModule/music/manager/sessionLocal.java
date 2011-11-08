package music.manager;
import javax.ejb.Local;

import music.data.User;

@Local
public interface sessionLocal {
	public User getUser(int id);
}
