package music.manager;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.User;
import music.data.UserVO;
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

	public UserVO checkLogin(String email, String password) {
		System.out.println("Aufruf checkLogin mit " + email + " und "
				+ password);
		User u = userDAO.findByEmail(email);
		try {
			if (u != null && SHA1Convert.SHA1(password).equals(u.getPassword())){
				UserVO user = new UserVO();
				user.setAdmin(u.getAdmin());
				user.setEmail(u.getEmail());
				user.setId(u.getId());
				user.setPassword(u.getPassword());
				return user;
			}
				
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
	public UserVO createUser(String email, String password) {
		return createUser(email,password, (byte) 0);
	}

	public UserVO createUser(String email, String password, byte admin) {
		try {
			User user = userDAO.createUser(email, SHA1Convert.SHA1(password), admin);
			UserVO vo = new UserVO();
			vo.setAdmin(user.getAdmin());
			vo.setEmail(user.getEmail());
			vo.setId(user.getId());
			vo.setPassword(user.getPassword());
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean changePassword(String email, String oldPassword,
			String newPassword) {
		try {
			if (checkLogin(email, oldPassword) != null) {
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
