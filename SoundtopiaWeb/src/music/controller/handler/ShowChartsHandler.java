package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.ManagerFactory;
import music.data.PriceVO;
import music.data.SongVO;
import music.data.SortType;
import music.data.UserVO;
import music.manager.ChartManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

@WebServlet("/ShowChartsHandler")
public class ShowChartsHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int SONGS_PER_SITE = 10;
	private int start, end;
	private String view = null;
	private List<SongVO> chartList = new ArrayList<SongVO>();
	private UserVO user;
	private int chartAnz;
	private boolean loggedIn;

	public ShowChartsHandler() {
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
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
	
		String operation = "";
		operation = request.getParameter("op");
		HttpSession session = request.getSession();

		System.out.println(chartManager);
		
		try {
			start = Integer.valueOf(request.getParameter("start"));
		} catch (NumberFormatException e) {
			start = (Integer) session.getAttribute("lastVisitSong");
		}
		
		session.setAttribute("lastVisitSong", start);
		
		try {
			end = Integer.valueOf(request.getParameter("end"));
		} catch (NumberFormatException e) {
			end = (Integer) session.getAttribute("lastVisitSong")
					+ SONGS_PER_SITE - 1;
		}

		loggedIn = (Boolean) session.getAttribute("loggedIn");

		if (loggedIn) {
			user = (UserVO) session.getAttribute("user");
			chartList = chartManager.showCharts("Singlecharts",
					start, end, user.getId(), SortType.RANKING);
		} else {
			chartList = chartManager.showCharts("Singlecharts",
					start, end, -1, SortType.RANKING);
		}

		chartAnz = chartManager.getMaxSongsInChart("Singlecharts");
		
		if (operation != null && operation.equals("update"))
			view = updateChartList(request, response);
		else
			view = showChartList(request, response);

		return view;
			
	}

	private String showChartList(HttpServletRequest request,
			HttpServletResponse response) {
		if (start + SONGS_PER_SITE <= chartAnz) {
			request.setAttribute("nextStart", start + SONGS_PER_SITE);
			request.setAttribute("nextEnd", end + SONGS_PER_SITE);
		}

		if (start - SONGS_PER_SITE > 0) {
			request.setAttribute("prevStart", start - SONGS_PER_SITE);
			request.setAttribute("prevEnd", end - SONGS_PER_SITE);
		}

		request.setAttribute("chartList", chartList);
		return "../views/charts.jsp";

	}

	private String updateChartList(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("update chartlist");
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();

			json.put("loggedIn", loggedIn);

			if (user != null) {
				JSONObject userJSON = new JSONObject();
				userJSON.put("admin", user.getAdmin());
				json.put("user", userJSON);
			}

			for (SongVO s : chartList) {
				JSONObject chart = new JSONObject();
				chart.put("id", s.getId());
				chart.put("interpreter", s.getInterpreter());
				chart.put("title", s.getTitle());
				chart.put("tracklength", s.getTracklength());
				chart.put("video", s.getVideo());
				chart.put("picture", s.getPicture());
				chart.put("ranking", s.getRanking());
				chart.put("rating", df.format(s.getRating()));
				chart.put("userRating", df.format(s.getUserRating()));
				chart.put("voteCount", s.getVoteCount());
				JSONObject lyric = new JSONObject();
				lyric.put("text", s.getLyric().getText());
				lyric.put("url", s.getLyric().getUrl());
				chart.put("lyric", lyric);
				chart.put("change", s.getChange());
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

			if (start + SONGS_PER_SITE <= chartAnz) {
				JSONObject next = new JSONObject();
				next.put("start", start + SONGS_PER_SITE);
				next.put("end", end + SONGS_PER_SITE);
				json.put("next", next);

			}

			if (start - SONGS_PER_SITE > 0) {
				JSONObject prev = new JSONObject();
				prev.put("start", start - SONGS_PER_SITE);
				prev.put("end", end - SONGS_PER_SITE);
				json.put("prev", prev);
			}

			response.setContentType("application/json");
			out.println(json);

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return null;
	}

}
