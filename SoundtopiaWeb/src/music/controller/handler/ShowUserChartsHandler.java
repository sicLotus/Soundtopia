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

import music.controller.ManagerFactory;
import music.data.PriceVO;
import music.data.SongVO;
import music.data.SortType;
import music.data.UserVO;
import music.manager.ChartManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

@WebServlet("/SearchHandler")
public class ShowUserChartsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<SongVO> results;
	private UserVO user;

	public ShowUserChartsHandler() {
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
		String sortType, mode;
		mode = request.getParameter("mode");
		sortType = request.getParameter("sortType");


		user = (UserVO) request.getSession().getAttribute("user");
		int userID = -1;

		if (user != null)
			userID = user.getId();

		if (sortType == null || sortType.equals("rating"))
			results = chartManager.showCharts("Singlecharts", 1, 10,
					userID, SortType.RATING);
		else
			results = chartManager.showCharts("Singlecharts", 1, 10,
					userID, SortType.VOTES);
		
		if (mode == null) {
			if (!results.isEmpty() || results != null) {
				request.setAttribute("chartList", results);
				view = "../views/topusercharts.jsp";
			}
		} else {
			returnJSON(request, response);
			view = null;
		}
		return view;
	}

	private void returnJSON(HttpServletRequest request,
			HttpServletResponse response) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
		
		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();
			Boolean loggedIn = (Boolean) request.getSession()
					.getAttribute("loggedIn");
			json.put("loggedIn", loggedIn);

			if (user != null) {
				JSONObject userJSON = new JSONObject();
				userJSON.put("admin", user.getAdmin());
				json.put("user", userJSON);
			}

			for (SongVO s : results) {
				JSONObject chart = new JSONObject();
				chart.put("id", s.getId());
				chart.put("interpreter", s.getInterpreter());
				chart.put("title", s.getTitle());
				chart.put("tracklength", s.getTracklength());
				chart.put("video", s.getVideo());
				chart.put("voteCount", s.getVoteCount());
				chart.put("picture", s.getPicture());
				chart.put("rating", df.format(s.getRating()));
				chart.put("userRating", df.format(s.getUserRating()));
				JSONObject lyric = new JSONObject();
				lyric.put("text", s.getLyric().getText());
				lyric.put("url", s.getLyric().getUrl());
				chart.put("lyric", lyric);
				for (PriceVO p : s.getPrices()) {
					JSONObject prices = new JSONObject();
					prices.put("provider", p.getProvider());
					prices.put("url", p.getUrl());
					prices.put("value", df.format(p.getValue()));
					prices.put("currency", p.getCurrency());
					chart.append("prices", prices);
				}
				json.append("chart", chart);

			}
			response.setContentType("application/json");
			out.println(json);

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
