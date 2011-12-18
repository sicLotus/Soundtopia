

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.manager.UserManagerLocal;

@WebServlet("/LoginHandlerTest")
public class LoginHandlerTest extends HttpServlet {

	@EJB
	private UserManagerLocal userManager;

	private static final long serialVersionUID = 1L;

	public LoginHandlerTest() {
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

		//String email = request.getParameter("iuser");
		//String password = request.getParameter("ipass");
		
		String email = "a";
		String password = "b";
		
		System.out.println("Userman "+userManager);
		System.out.println(email + " " + password+"haha");

		allowUser = userManager.checkLogin(email, password);

		if (!allowUser) {
			view = "/error/loginErr.jsp";
		} else {
			session.setAttribute("email", email);
			view = "/controller/showBooks";
			session.setAttribute("loggedIn", new Boolean(allowUser));
		}
		return view;
	}
}
