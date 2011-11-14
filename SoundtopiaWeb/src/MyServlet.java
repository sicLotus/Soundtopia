

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.manager.SessionLocal;
import music.manager.UserManagerLocal;



/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	SessionLocal test;
	
	@EJB
	UserManagerLocal userManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(test.getUser(1).getEmail());	
		//System.out.println(test.getSong(1).getInterpreter());
		//System.out.println(test.getSong(1).getLyric().getText());
		//System.out.println(test.findByEmail("asda@asd.de").getId());
		//userManager.createUser("Mateful@web.de", "sicLotus");
		//System.out.println(userManager.findByEmail("Mateful@web.de").getId());
		//System.out.println(userManager.checkLogin("Mateful@web.de", "sicLotu1s"));
		userManager.changePassword("Mateful@web.de", "sicLotus", "ben2");
		System.out.println("fd5dc0798250b169f94fb9d1cde2febe5503f77b");
		System.out.println(userManager.findByEmail("Mateful@web.de").getPassword());
		System.out.println(userManager.checkLogin("Mateful@web.de", "ben"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
