package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.UserVO;
import music.exception.SoundtopiaException;
import music.manager.UserManagerLocal;
import music.util.SessionUtil;

public class LoginHandler implements IForwardHandler {

	public LoginHandler() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		UserManagerLocal userManager = (UserManagerLocal) ManagerFactory.getManager("UserManager", ManagerFactory.Mode.Local);
		HttpSession session = request.getSession();
		if (!SessionUtil.isLoggedIn(session)) {
			String email = request.getParameter("iuser");
			String password = request.getParameter("ipass");
			UserVO user = userManager.checkLogin(email, password);

			SessionUtil.setLogin(session, user);
			System.out.println("Login:"+session.getAttribute("loggedIn")+" "+ session.getAttribute("user"));

			return "../controller/showCharts";
		}
		throw new SoundtopiaException("Sie sind bereits eingeloggt.");
	}
}
