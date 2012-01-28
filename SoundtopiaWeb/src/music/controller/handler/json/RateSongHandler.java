package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.UserVO;
import music.exception.NoLoginException;
import music.manager.SongManagerLocal;
import music.util.JSONUtil;
import music.util.SessionUtil;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class RateSongHandler extends JSONProcessHandler {

	public RateSongHandler() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		HttpSession session = request.getSession();

		if (SessionUtil.isLoggedIn(session)) {
			SongManagerLocal songManager = (SongManagerLocal) ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
			UserVO user = SessionUtil.getUser(request.getSession());
			int songID = Integer.valueOf(request.getParameter("songID"));
			int rating = Integer.valueOf(request.getParameter("rating"));

			songManager.rateASong(user.getId(), songID, rating);

			float meanRate = songManager.getMeanRate(songID);
			int votes = songManager.getVoteCount(songID);

			json = JSONUtil.putRating(json, votes, meanRate);
			return json;

		} else {
			throw new NoLoginException();
		}
	}

}
