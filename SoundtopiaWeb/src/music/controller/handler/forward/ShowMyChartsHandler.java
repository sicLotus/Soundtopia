package music.controller.handler.forward;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ManagerFactory;
import music.data.SortType;
import music.data.ValueObject.SongVO;
import music.manager.ChartManager;
import music.manager.ChartManagerLocal;
import music.util.SessionUtil;

public class ShowMyChartsHandler implements IForwardHandler {

	public ShowMyChartsHandler() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		int userID = SessionUtil.getUser(request.getSession()).getId();
		List<SongVO> results = chartManager.showCharts(ChartManager.SINGLECHARTS, 1, 10, userID, SortType.USERVOTES);
		request.setAttribute("chartList", results);
		return "../views/usercharts.jsp";
	}
}
