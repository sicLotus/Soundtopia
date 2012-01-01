package music.controller.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.data.SongVO;
import music.data.SortType;
import music.data.UserVO;
import music.manager.ChartManagerLocal;

@WebServlet("/SearchHandler")
public class ShowMyChartsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowMyChartsHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
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
