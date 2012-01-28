package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ShowUserChartsHelper;
import music.util.JSONUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class ShowUserChartsHandlerJSON extends JSONProcessHandler {

	public ShowUserChartsHandlerJSON() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		ShowUserChartsHelper helper = new ShowUserChartsHelper(request, response);
		Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
		json = JSONUtil.putLoggedIn(json, loggedIn);
		json = JSONUtil.putUser(json, helper.getUser());
		json = JSONUtil.putChart(json, helper.getChartList());
		return json;
	}
}
