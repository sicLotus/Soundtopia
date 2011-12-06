package music.manager;
import javax.ejb.Local;

@Local
public interface UserManagerLocal {
	
	public boolean checkLogin(String email, String password);
	public boolean changePassword(String email, String oldPassword, String newPassword);
	public boolean createUser(String email, String password);
}
