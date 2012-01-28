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

public class UndoChangesHandler extends JSONProcessHandler {

	public UndoChangesHandler() {
		super();
	}

	@Override
	protected JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, JSONObject json) throws JSONException {
		SongManagerLocal songManager = (SongManagerLocal) ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
		UserVO user = SessionUtil.getUser(request.getSession());
		if (user.isAdmin()) {
			SongVO song = undoChanges(request, songManager);
			json = JSONUtil.putSong(json, song);
			return json;
		} else
			throw new NoAdminException();
	}

	private SongVO undoChanges(HttpServletRequest request, SongManagerLocal songManager) {
		int songID = Integer.valueOf(request.getParameter("songID"));
		songManager.undoChanges(songID);
		SongVO song = songManager.getSong(songID);
		songManager.readNewSongInformationFromAPIs(songID, song.getInterpreter(), song.getTitle());
		song = songManager.getSong(songID);
		return song;
	}
}
