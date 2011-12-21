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
import music.data.UserVO;
import music.manager.UserManagerLocal;

@WebServlet("/RegisterHandler")
public class RegisterHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserManagerLocal userManager;

	public RegisterHandler() {
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
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		HttpSession session = request.getSession();

		String email = request.getParameter("emailR");
		String password = request.getParameter("passwordR");

		UserVO user = Controller.userManager.createUser(email, password);

		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("loggedIn", new Boolean(true));
			view = "../controller/showCharts";
		} else
			view = "../error/registerErr.jsp";

		return view;
	}

}
