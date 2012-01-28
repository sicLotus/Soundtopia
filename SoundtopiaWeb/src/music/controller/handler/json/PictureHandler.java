package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.UserVO;
import music.exception.NoAdminException;
import music.exception.SoundtopiaException;
import music.manager.SongManagerLocal;
import music.util.JSONUtil;
import music.util.SessionUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class PictureHandler extends JSONProcessHandler {
	private String[] apis = {"Google Picture API", "Amazon API"};

	public PictureHandler() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		UserVO user = SessionUtil.getUser(request.getSession());

		if (user.isAdmin()) {
			json = JSONUtil.putURL(json, getURL(request));
			return json;
		} else
			throw new NoAdminException();
	}

	private String getURL(HttpServletRequest request) {
		SongManagerLocal songManager = (SongManagerLocal) ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
		String interpreter = request.getParameter("interpreter");
		String title = request.getParameter("title");
		String api = request.getParameter("api");
		int index = Integer.valueOf(request.getParameter("index"));

		if (api.equals(apis[0])) {
			return songManager.getPictureFromGoogle(interpreter, title, index);
		} else if (api.equals(apis[1])) {
			return songManager.getPictureFromAmazon(interpreter, title);
		} else
			throw new SoundtopiaException("Nicht unterstützte API");
	}
}
