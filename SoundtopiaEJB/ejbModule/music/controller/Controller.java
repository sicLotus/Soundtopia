package music.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.handler.LoginHandler;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// EJB injezieren
	/*
	 * @EJB User userHelper; ...
	 */

	@PersistenceUnit
	private EntityManager em;

	// BusinessObjekte anlegen
	/*
	 * private UserBO userBO; ...
	 */

	private ServletConfig servletConfig;

	public Controller() {
		super();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			processRequest(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
				try {		
					processRequest(request,response);			
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
	
	private void initializeSession(HttpSession session) {
	/*
			if (session.getAttribute("userBO") == null) {
				userBO = new UserBO(userHelper);
				session.setAttribute("userBO", userBO);
			}
	*/
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String pathInfo = request.getPathInfo();
		String view = null;
		
		HttpSession session = request.getSession();
		
		initializeSession(session);
				
		if (pathInfo == null || "/".equals(pathInfo))
			   response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		
		String servlet = pathInfo.substring(1);
		System.out.println("pathinfo = "+pathInfo);
		System.out.println("servlet = "+servlet);
		
		//die site sollte jetzt mit localhost/controller/login aufgerufen werden können
		if(servlet.equals("login")){
			LoginHandler handler = new LoginHandler();
			view = handler.processRequest(request, response);
		}
		
		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		    dispatcher.forward(request, response);
			}			
		}
}
