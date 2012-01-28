package music.controller.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.data.SortType;
import music.data.ValueObject.SongVO;
import music.data.ValueObject.UserVO;
import music.exception.SoundtopiaException;
import music.manager.ChartManager;
import music.manager.ChartManagerLocal;
import music.util.SessionUtil;

public class ShowChartsHelper {
	private int SONGS_PER_SITE = 10;
	private int start, end;

	private List<SongVO> chartList = new ArrayList<SongVO>();
	private UserVO user;
	private int chartAnz;
	private Boolean loggedIn;

	public ShowChartsHelper(HttpServletRequest request, HttpServletResponse response) {
		super();
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		HttpSession session = request.getSession();
		loggedIn = SessionUtil.isLoggedIn(session);
		start = getStartSongRanking(request);
		SessionUtil.setLastVisitSong(session, start);
		end = getEndSongRanking(request);
		int userID = getUserID(request);
		chartList = chartManager.showCharts(ChartManager.SINGLECHARTS, start, end, userID, SortType.RANKING);
		chartAnz = chartManager.getMaxSongsInChart(ChartManager.SINGLECHARTS);
	}

	private int getUserID(HttpServletRequest request) {
		try {
			user = SessionUtil.getUser(request.getSession());
			return user.getId();
		} catch (SoundtopiaException e) {
			return -1;
		}
	}

	private int getStartSongRanking(HttpServletRequest request) {
		try {
			return Integer.valueOf(request.getParameter("start"));
		} catch (NumberFormatException e) {
			return SessionUtil.getLastVisitSong(request.getSession());
		}
	}

	private int getEndSongRanking(HttpServletRequest request) {
		try {
			return Integer.valueOf(request.getParameter("end"));
		} catch (NumberFormatException e) {
			return SessionUtil.getLastVisitSong(request.getSession()) + SONGS_PER_SITE - 1;
		}
	}
	public int getSONGS_PER_SITE() {
		return SONGS_PER_SITE;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public List<SongVO> getChartList() {
		return chartList;
	}

	public UserVO getUser() {
		return user;
	}

	public int getChartAnz() {
		return chartAnz;
	}

	public Boolean isLoggedIn() {
		return loggedIn;
	}

}
