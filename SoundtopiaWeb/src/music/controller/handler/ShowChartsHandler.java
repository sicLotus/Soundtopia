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

import music.controller.Controller;
import music.data.PriceVO;
import music.data.SongVO;
import music.data.UserVO;
import music.util.JSONException;
import music.util.JSONObject;

@WebServlet("/ShowChartsHandler")
public class ShowChartsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int SONGS_PER_SITE = 10;

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
		String view = null;
		String operation = "";
		operation = request.getParameter("op");

		if (operation != null && operation.equals("update")) {
			updateChartList(request, response);
			view = null;
		} else {
			List<SongVO> chartList = new ArrayList<SongVO>();
			int start, end;
			try {
				start = Integer.valueOf(request.getParameter("start"));
			} catch (NumberFormatException e) {
				start = 1;
			}
			try {
				end = Integer.valueOf(request.getParameter("end"));
			} catch (NumberFormatException e) {
				end = SONGS_PER_SITE;
			}

			HttpSession session = request.getSession();
			boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

			if (loggedIn) {
				UserVO user = (UserVO) session.getAttribute("user");
				chartList = Controller.chartManager.showCharts("Singlecharts",
						start, end, user.getId());
			} else {
				chartList = Controller.chartManager.showCharts("Singlecharts",
						start, end, -1);
			}

			int chartAnz = Controller.chartManager
					.getMaxSongsInChart("Singlecharts");

			System.out.println("start:"+start+" + "+SONGS_PER_SITE +" <= max:"+chartAnz);
			if (start + SONGS_PER_SITE <= chartAnz) {
				System.out.println("next");
				request.setAttribute("nextStart", start + SONGS_PER_SITE);
				request.setAttribute("nextEnd", end + SONGS_PER_SITE);
			}

			if (start - SONGS_PER_SITE > 0) {
				System.out.println("prev");
				request.setAttribute("prevStart", start - SONGS_PER_SITE);
				request.setAttribute("prevEnd", end - SONGS_PER_SITE);
			}
			
			for(SongVO s : chartList) {
				System.out.println(s.getInterpreter());
			}

			request.setAttribute("chartList", chartList);

			view = "../views/charts.jsp";
		}
		return view;
	}

	private void updateChartList(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("update chartlist");
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
		List<SongVO> chartList = new ArrayList<SongVO>();
		int start, end;
		try {
			start = Integer.valueOf(request.getParameter("start"));
		} catch (NumberFormatException e) {
			start = 1;
		}
		try {
			end = Integer.valueOf(request.getParameter("end"));
		} catch (NumberFormatException e) {
			end = SONGS_PER_SITE;
		}

		System.out.println("EJB: " + Controller.chartManager);
		HttpSession session = request.getSession();
		boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		UserVO user;
		if (loggedIn) {
			user = (UserVO) session.getAttribute("user");
			chartList = Controller.chartManager.showCharts("Singlecharts",
					start, end, user.getId());
		} else {
			user = null;
			chartList = Controller.chartManager.showCharts("Singlecharts",
					start, end, -1);
		}
		int chartAnz = Controller.chartManager
				.getMaxSongsInChart("Singlecharts");
		
		System.out.println("max:"+chartAnz+" start:"+start+" end:"+end);

		for(SongVO s : chartList) {
			System.out.println(s.getInterpreter());
		}
		
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
				chart.put("rating", s.getRating());
				chart.put("picture", s.getPicture());
				chart.put("ranking", s.getRanking());
				chart.put("rating", s.getRating());
				chart.put("userRating", s.getUserRating());
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
	}

}
