package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.util.JSONException;
import music.util.JSONObject;

/**
 * Servlet implementation class PictureHandler
 */
@WebServlet("/PictureHandler")
public class PictureHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] apis = { "Google Picture API", "Amazon API" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PictureHandler() {
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

		String interpreter = request.getParameter("interpreter");
		String title = request.getParameter("title");
		String api = request.getParameter("api");
		int index = Integer.valueOf(request.getParameter("index"));

		String url = "";

		if (api.equals(apis[0])) {
			url = Controller.sessionManager.getPictureFromGoogle(interpreter,
					title, index);
		} else if (api.equals(apis[1])) {
			url = Controller.sessionManager.getPictureFromAmazon(interpreter,
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
