package music.controller.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.data.SortType;
import music.data.ValueObject.SongVO;
import music.data.ValueObject.UserVO;
import music.exception.SoundtopiaException;
import music.manager.ChartManager;
import music.manager.ChartManagerLocal;
import music.util.SessionUtil;

public class ShowUserChartsHelper {
	private List<SongVO> chartList;
	private UserVO user;

	public ShowUserChartsHelper(HttpServletRequest request, HttpServletResponse response) {
		super();
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		String sortType = request.getParameter("sortType");
		int userID = getUserID(request);

		if (sortType == null || sortType.equals("rating"))
			chartList = chartManager.showCharts(ChartManager.SINGLECHARTS, 1, 10, userID, SortType.RATING);
		else
			chartList = chartManager.showCharts(ChartManager.SINGLECHARTS, 1, 10, userID, SortType.VOTES);
	}

	public List<SongVO> getChartList() {
		return chartList;
	}

	public UserVO getUser() {
		return user;
	}
	
	private int getUserID(HttpServletRequest request) {
		try {
			user = SessionUtil.getUser(request.getSession());
			return user.getId();
		} catch (SoundtopiaException e) {
			return -1;
		}
	}
}
