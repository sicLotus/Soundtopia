package music.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.manager.SessionLocal;

public class ReadChartsHandler {     

    public ReadChartsHandler() {
        super();
    }

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		SessionLocal sessionManager = (SessionLocal) ManagerFactory.getManager("Session", ManagerFactory.Mode.Local);

		sessionManager.readChartsFromMyvideo();		
		return view;
	}


}
