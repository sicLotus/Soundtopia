package music.controller.handler.forward;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.ValueObject.SongVO;
import music.data.ValueObject.UserVO;
import music.exception.SoundtopiaException;
import music.manager.ChartManager;
import music.manager.ChartManagerLocal;
import music.util.SessionUtil;

public class SearchSongHandler implements IForwardHandler {

	public SearchSongHandler() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		List<SongVO> results = doSearch(request);
		return getForwardString(request, results);
	}

	private List<SongVO> doSearch(HttpServletRequest request) {
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		String searchStr = request.getParameter("searchinput");
		searchStr = searchStr.replaceAll("\\p{Punct}", "");
		String[] search = searchStr.split(" ");
		List<SongVO> results;
		int userID = getUserID(request);
		results = chartManager.searchSongs(userID, search, ChartManager.SINGLECHARTS);
		return results;
	}

	private String getForwardString(HttpServletRequest request, List<SongVO> results) {
		if (results.isEmpty() || results == null) {
			throw new SoundtopiaException("Ihre Suche ergab keine Übereinstimmungen.");
		} else {
			request.setAttribute("chartList", results);
			return "../views/searchResults.jsp";
		}
	}

	private int getUserID(HttpServletRequest request) {
		try {
			UserVO user = SessionUtil.getUser(request.getSession());
			return user.getId();
		} catch (SoundtopiaException e) {
			return -1;
		}
	}
}
