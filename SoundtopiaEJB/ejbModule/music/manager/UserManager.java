package music.manager;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.DataObject.User;
import music.data.ValueObject.UserVO;
import music.exception.SoundtopiaException;
import music.repository.UserDAO;
import music.util.SHA1Convert;

/**
 * Session Bean implementation class UserManager
 */
@Stateless
public class UserManager implements UserManagerRemote, UserManagerLocal {

	@EJB
	private UserDAO userDAO;
	private static final byte NO_ADMIN_FLAG = 0;
	private static final byte ADMIN_FLAG = 1;

	public UserManager() {
	}

	public UserVO checkLogin(String email, String password) {
		try {
			User u = userDAO.findByEmail(email);
			if (u != null && SHA1Convert.SHA1(password).equals(u.getPassword())) {
				UserVO user = new UserVO();
				user.setAdmin(u.getAdmin());
				user.setEmail(u.getEmail());
				user.setId(u.getId());
				user.setPassword(u.getPassword());
				return user;
			} else
				throw new SoundtopiaException("Login fehlgeschlagen.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new SoundtopiaException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new SoundtopiaException(e.getMessage());
		}
	}

	public UserVO createUser(String email, String password, boolean admin) {
		if (admin)
			return createAdmin(email, password);
		else
			return createUser(email, password);
	}

	public UserVO createUser(String email, String password) {
		return createUser(email, password, NO_ADMIN_FLAG);
	}
	public UserVO createAdmin(String email, String password) {
		return createUser(email, password, ADMIN_FLAG);
	}

	private UserVO createUser(String email, String password, byte admin) {
		try {
			System.out.println("create user");
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

	public boolean changePassword(String email, String oldPassword, String newPassword) {
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
