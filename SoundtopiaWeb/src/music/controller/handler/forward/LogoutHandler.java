package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.util.SessionUtil;

public class LogoutHandler implements IForwardHandler {

	public LogoutHandler() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String view = "../controller/showCharts";
		synchronized (session) {
			SessionUtil.removeUser(session);
			SessionUtil.setLoggedIn(session, false);
		}
		return view;
	}
}
