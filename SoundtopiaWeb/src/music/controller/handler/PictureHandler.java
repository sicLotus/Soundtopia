package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.manager.SessionLocal;
import music.util.JSONException;
import music.util.JSONObject;

public class PictureHandler {
	private String[] apis = { "Google Picture API", "Amazon API" };

	public PictureHandler() {
		super();
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SessionLocal sessionManager = (SessionLocal) ManagerFactory.getManager("Session", ManagerFactory.Mode.Local);
		String view = null;

		String interpreter = request.getParameter("interpreter");
		String title = request.getParameter("title");
		String api = request.getParameter("api");
		int index = Integer.valueOf(request.getParameter("index"));

		String url = "";

		if (api.equals(apis[0])) {
			url = sessionManager.getPictureFromGoogle(interpreter,
					title, index);
		} else if (api.equals(apis[1])) {
			url = sessionManager.getPictureFromAmazon(interpreter,
					title);
		}

		try {
			PrintWriter out;
			out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("url", url);
			response.setContentType("application/json");
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

		return view;
	}

}
