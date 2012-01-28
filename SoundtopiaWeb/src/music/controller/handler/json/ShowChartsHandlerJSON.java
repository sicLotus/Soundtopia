package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ShowChartsHelper;
import music.util.JSONUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class ShowChartsHandlerJSON extends JSONProcessHandler {

	public ShowChartsHandlerJSON() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		ShowChartsHelper helper = new ShowChartsHelper(request, response);
		json = JSONUtil.putLoggedIn(json, helper.isLoggedIn());
		System.out.println("isLoggedIn:"+helper.isLoggedIn());
		json = JSONUtil.putUser(json, helper.getUser());
		json = JSONUtil.putChart(json, helper.getChartList());
		json = JSONUtil.putNext(json, helper.getStart(), helper.getEnd(), helper.getSONGS_PER_SITE(), helper.getChartAnz());
		json = JSONUtil.putPrev(json, helper.getStart(), helper.getEnd(), helper.getSONGS_PER_SITE());
		return json;
	}
}
