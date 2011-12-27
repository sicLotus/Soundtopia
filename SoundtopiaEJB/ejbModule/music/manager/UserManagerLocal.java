package music.manager;
import javax.ejb.Local;

import music.data.UserVO;

@Local
public interface UserManagerLocal {
	
	public UserVO checkLogin(String email, String password);
	public boolean changePassword(String email, String oldPassword, String newPassword);
	public UserVO createUser(String email, String password);
	public UserVO createUser(String email, String password, byte admin);
}
