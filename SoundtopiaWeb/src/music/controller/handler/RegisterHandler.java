package music.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.ManagerFactory;
import music.data.UserVO;
import music.manager.UserManagerLocal;

public class RegisterHandler  {


	public RegisterHandler() {
		super();
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
