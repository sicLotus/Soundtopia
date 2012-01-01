package music.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.ManagerFactory;
import music.data.UserVO;
import music.manager.UserManagerLocal;

@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		UserManagerLocal userManager = (UserManagerLocal) ManagerFactory.getManager("UserManager", ManagerFactory.Mode.Local);
		String view = null;
		HttpSession session = request.getSession();

		String email = request.getParameter("iuser");
		String password = request.getParameter("ipass");

		System.out.println("UserManager:\n" + userManager);
		System.out.println("loginhandler: "+email+ " "+password);

		UserVO user = userManager.checkLogin(email, password);

		if (user != null) {
			session.setAttribute("user", user);
			view = "../controller/showCharts";
			session.setAttribute("loggedIn", new Boolean(true));
		} else {
			view = "/error/loginErr.jsp";
		}
		return view;
	}
}
