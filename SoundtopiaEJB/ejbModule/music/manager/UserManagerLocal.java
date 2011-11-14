package music.manager;
import javax.ejb.Local;

import music.data.User;

@Local
public interface UserManagerLocal {
	
	public boolean createUser(String email, String password);
	public User findByEmail(String email);
	public boolean checkLogin(String email, String password);
	public boolean changePassword(String email, String oldPassword, String newPassword);
}
