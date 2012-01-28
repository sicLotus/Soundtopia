package music.util;

import javax.servlet.http.HttpSession;

import music.data.ValueObject.UserVO;
import music.exception.NoLoginException;

public class SessionUtil {
	private SessionUtil() {
	}

	public static UserVO getUser(HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		if (user == null)
			throw new NoLoginException();
		else
			return user;
	}

	public static void setUser(HttpSession session, UserVO user) {
		if (user != null)
			session.setAttribute("user", user);
	}

	public static void setLoggedIn(HttpSession session, Boolean loggedIn) {
		if (loggedIn != null)
			session.setAttribute("loggedIn", loggedIn);
		else
			session.setAttribute("loggedIn", new Boolean(false));
	}

	public static void setLastVisitSong(HttpSession session, Integer lastVisitSong) {
		synchronized (session) {
			if (lastVisitSong != null)
				session.setAttribute("lastVisitSong", lastVisitSong);
			else
				session.setAttribute("lastVisitSong", 1);
		}
	}

	public static Integer getLastVisitSong(HttpSession session) {
		Integer lastVisitSong = (Integer) session.getAttribute("lastVisitSong");
		if (lastVisitSong == null)
			return 1;
		else
			return lastVisitSong;
	}

	public static Boolean isLoggedIn(HttpSession session) {
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		if (loggedIn == null)
			return new Boolean(false);
		else
			return loggedIn;
	}

	public static void setLogin(HttpSession session, UserVO user) {
			setUser(session, user);
			setLoggedIn(session, new Boolean(true));
	}

	public static void removeUser(HttpSession session) {
		removeAttribute(session, "user");
	}

	public static void removeAttribute(HttpSession session, String msg) {
		session.removeAttribute(msg);
	}
}
