package music.controller.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.data.SongVO;
import music.data.SortType;
import music.data.UserVO;
import music.manager.ChartManagerLocal;

public class ShowMyChartsHandler {

	public ShowMyChartsHandler() {
		super();
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		int userID = -1;

		if (user != null)
			userID = user.getId();

		List<SongVO> results = chartManager.showCharts(
				"Singlecharts", 1, 10, userID, SortType.USERVOTES);

		request.setAttribute("chartList", results);
		view = "../views/usercharts.jsp";

		return view;
	}
}
