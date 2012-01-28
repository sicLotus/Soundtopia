package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.manager.ChartManager;
import music.manager.ChartManagerLocal;
import music.util.JSONUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class SearchSuggestHandler extends JSONProcessHandler {

	public SearchSuggestHandler() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		String searchStr = request.getParameter("searchinput");
		String[] search = searchStr.split(",");
		String searchResult = chartManager.suggestSearch(search, ChartManager.SINGLECHARTS);
		json = JSONUtil.putSearchResults(json, searchResult);
		return json;
	}
}
