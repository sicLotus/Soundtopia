package music.manager;
import javax.ejb.Remote;

import music.data.ValueObject.UserVO;

@Remote
public interface UserManagerRemote {
	public UserVO checkLogin(String email, String password);
	public boolean changePassword(String email, String oldPassword, String newPassword);
	public UserVO createUser(String email, String password);
	public UserVO createAdmin(String email, String password);
	public UserVO createUser(String email, String password, boolean admin);
}
