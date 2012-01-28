package music.controller.handler.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.util.json.JSONException;
import music.util.json.JSONObject;

public abstract class JSONProcessHandler implements IJSONProcessHandler {
	public void processJSON(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();
			json = processRequest(request, response, json);
			response.setContentType("application/json");
			out.println(json);

		} catch (IOException io) {
			io.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	protected abstract JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException;
}
