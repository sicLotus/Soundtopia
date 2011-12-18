package music.controller.handler;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.Controller;
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

		String view = null;
		HttpSession session = request.getSession();
		boolean allowUser = false;

		String email = request.getParameter("iuser");
		String password = request.getParameter("ipass");

		System.out.println("UserManager:\n" + Controller.userManager);

		allowUser = Controller.userManager.checkLogin(email, password);

		if (!allowUser) {
			view = "/error/loginErr.jsp";
		} else {
			session.setAttribute("email", email);
			view = "../controller/showCharts";
			session.setAttribute("loggedIn", new Boolean(allowUser));
		}
		return view;
	}
}
