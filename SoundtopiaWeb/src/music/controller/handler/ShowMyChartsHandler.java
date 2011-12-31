package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.data.PriceVO;
import music.data.SongVO;
import music.data.SortType;
import music.data.UserVO;
import music.util.JSONException;
import music.util.JSONObject;

/**
 * Servlet implementation class SearchHandler
 */
@WebServlet("/SearchHandler")
public class ShowMyChartsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
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

		UserVO user = (UserVO) request.getSession().getAttribute("user");
		int userID = -1;

		if (user != null)
			userID = user.getId();

		List<SongVO> results = Controller.chartManager.showCharts(
				"Singlecharts", 1, 10, userID, SortType.USERVOTES);

		request.setAttribute("chartList", results);
		view = "../views/usercharts.jsp";

		return view;
	}
}
