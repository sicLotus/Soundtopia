package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.UserVO;
import music.manager.UserManagerLocal;
import music.util.SessionUtil;

public class RegisterHandler implements IForwardHandler {

	public RegisterHandler() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		UserManagerLocal userManager = (UserManagerLocal) ManagerFactory.getManager("UserManager", ManagerFactory.Mode.Local);
		HttpSession session = request.getSession();
		String email = request.getParameter("emailR");
		String password = request.getParameter("passwordR");
		String adminStr = request.getParameter("adminR");
		UserVO user = userManager.createUser(email, password, isAdminOn(adminStr));
		SessionUtil.setLogin(session, user);
		return "../controller/showCharts";
	}

	private boolean isAdminOn(String adminStr) {
		if(adminStr != null)
			return adminStr.equals("on");
		else return false;
	}

}
