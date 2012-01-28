package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.SongVO;
import music.data.ValueObject.UserVO;
import music.exception.NoAdminException;
import music.manager.SongManagerLocal;
import music.util.JSONUtil;
import music.util.SessionUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class ChangeSongHandler extends JSONProcessHandler {

	public ChangeSongHandler() {
		super();
	}

	private JSONObject changeSongInformation(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		SongManagerLocal songManager = (SongManagerLocal) ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
		String interpreter = request.getParameter("interpreter");
		String title = request.getParameter("title");
		String cover = request.getParameter("cover");
		int songID = Integer.valueOf(request.getParameter("songID"));
		SongVO song = new SongVO(interpreter, title, cover);
		songManager.changeSongInformation(songID, song);
		song = songManager.getSong(songID);
		return JSONUtil.putSong(json, song);
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		UserVO user = SessionUtil.getUser(request.getSession());
		if (user.isAdmin()) {
			return changeSongInformation(request, response, json);
		}
		 throw new NoAdminException();
	}
}
