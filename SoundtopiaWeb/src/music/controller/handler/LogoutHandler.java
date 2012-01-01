package music.controller.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutHandler {
       
    public LogoutHandler() {
        super();
    }
	
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		System.out.println("logout");
		String view = "../controller/showCharts";
		
		session.removeAttribute("user");
		session.setAttribute("loggedIn", new Boolean(false));

		return view;
		
	}

}
