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

@WebServlet("/RegisterHandler")
public class RegisterHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		UserManagerLocal userManager = (UserManagerLocal) ManagerFactory.getManager("UserManager", ManagerFactory.Mode.Local);

		String view = null;
		HttpSession session = request.getSession();

		String email = request.getParameter("emailR");
		String password = request.getParameter("passwordR");
		String adminStr = request.getParameter("adminR");
		byte admin;
		if (adminStr != null && adminStr.equals("on"))
			admin = 1;
		else admin = 0;
		
		System.out.println("register: "+email+" "+password + " "+admin);

		UserVO user = userManager.createUser(email, password, admin);
		
		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("loggedIn", new Boolean(true));
			view = "../controller/showCharts";
		} else
			view = "../error/registerErr.jsp";

		return view;
	}

}
