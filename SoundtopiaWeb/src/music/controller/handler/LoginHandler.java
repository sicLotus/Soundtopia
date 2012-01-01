package music.controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.ManagerFactory;
import music.data.UserVO;
import music.manager.UserManagerLocal;

public class LoginHandler {

	public LoginHandler() {
		super();
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		UserManagerLocal userManager = (UserManagerLocal) ManagerFactory
				.getManager("UserManager", ManagerFactory.Mode.Local);
		String view = null;
		HttpSession session = request.getSession();

		String email = request.getParameter("iuser");
		String password = request.getParameter("ipass");

		System.out.println("UserManager:\n" + userManager);
		System.out.println("loginhandler: " + email + " " + password);

		UserVO user = userManager.checkLogin(email, password);

		if (user != null) {
			synchronized (session) {
				session.setAttribute("user", user);
				session.setAttribute("loggedIn", new Boolean(true));
			}
			view = "../controller/showCharts";
		} else {
			view = "/error/loginErr.jsp";
		}
		return view;
	}
}
