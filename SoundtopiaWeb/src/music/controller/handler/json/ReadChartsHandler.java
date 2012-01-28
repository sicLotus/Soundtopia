package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.UserVO;
import music.manager.ChartManagerLocal;
import music.util.SessionUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class ReadChartsHandler extends JSONProcessHandler {

	public ReadChartsHandler() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		UserVO user = SessionUtil.getUser(request.getSession());
		if (user.isAdmin()) {
			ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
			chartManager.readChartsFromMyVideoIntoDatabase();
		}
		return json;
	}
}
