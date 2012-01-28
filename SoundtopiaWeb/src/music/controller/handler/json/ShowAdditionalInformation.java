package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.SongAdditionVO;
import music.data.ValueObject.UserVO;
import music.exception.NoAdminException;
import music.manager.SongManagerLocal;
import music.util.JSONUtil;
import music.util.SessionUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class ShowAdditionalInformation extends JSONProcessHandler {

	public ShowAdditionalInformation() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		SongManagerLocal songManager = (SongManagerLocal) ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
		UserVO user = SessionUtil.getUser(request.getSession());

		if (user.isAdmin()) {
			int songID = Integer.valueOf(request.getParameter("songID"));
			SongAdditionVO songAddition = songManager.getSongInformation(songID);
			json = JSONUtil.putSongAddition(json, songAddition);
			return json;
		} else
			throw new NoAdminException();
	}
}
