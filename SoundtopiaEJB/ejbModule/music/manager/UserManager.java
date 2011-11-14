package music.manager;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.User;
import music.repository.UserDAO;
import music.util.SHA1Convert;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
public class UserManager implements UserManagerRemote, UserManagerLocal {

	@EJB
	private UserDAO userDAO;

	public UserManager() {
	}

	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	public boolean checkLogin(String email, String password) {
		User u = userDAO.findByEmail(email);
		
		try {
			if (u != null && SHA1Convert.SHA1(password).equals(u.getPassword()))
				return true;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean createUser(String email, String password) {
		try {
			userDAO.createUser(email, SHA1Convert.SHA1(password));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	

	public boolean changePassword(String email, String oldPassword, String newPassword) {
		try {
			if (checkLogin(email, oldPassword)) {
				userDAO.setPassword(email, SHA1Convert.SHA1(newPassword));
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
