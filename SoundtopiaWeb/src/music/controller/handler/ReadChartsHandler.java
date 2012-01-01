package music.controller.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.manager.SessionLocal;




@WebServlet("/ReadChartsHandler")
public class ReadChartsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReadChartsHandler() {
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
		SessionLocal sessionManager = (SessionLocal) ManagerFactory.getManager("Session", ManagerFactory.Mode.Local);

		sessionManager.readChartsFromMyvideo();
		//view="../controller/showCharts";
		
		return view;
	}


}
