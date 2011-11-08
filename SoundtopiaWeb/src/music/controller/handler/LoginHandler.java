package music.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.manager.UserBOLocal;

@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginHandler() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
	
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String view = null;
		HttpSession session = request.getSession();
		
		
		
		//boolean allowUser = false;
		//String username = request.getParameter("account");
		//String password = request.getParameter("password");
		
		UserBOLocal userHelper = (UserBOLocal) session.getAttribute("userBO");
		//allowUser = userHelper.checkLogin(username, password);
		System.out.println(userHelper.getUser(1).getEmail());
		
//		if (!allowUser) {
//			view = "/error/loginErr.jsp";
//		} else {
//			//User user = new User();
//			//user = userHelper.getUser(username);
//			//session.setAttribute("userObject", user);
//			view = "/controller/showBooks";
//			session.setAttribute("eingeloggt", new Boolean(allowUser));
//		}
		return view;
	}

}
