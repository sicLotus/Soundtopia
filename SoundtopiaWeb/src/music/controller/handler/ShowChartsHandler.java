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
				start = Integer.valueOf(request.getParameter("startChart"));
			} catch (NumberFormatException e) {
				start = 1;
			}
			try {
				end = Integer.valueOf(request.getParameter("endChart"));
			} catch (NumberFormatException e) {
				end = 25;
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
//			for (SongVO s : chartList) {
//				System.out.println(s.getRanking() + ": " + s.getInterpreter()
//						+ " " + s.getTitle());
//			}

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
			start = Integer.valueOf(request.getParameter("startChart"));
		} catch (NumberFormatException e) {
			start = 1;
		}
		try {
			end = Integer.valueOf(request.getParameter("endChart"));
		} catch (NumberFormatException e) {
			end = 25;
		}

		System.out.println("EJB: " + Controller.chartManager);
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
		
//		for (SongVO s : chartList) {
//			System.out.println(s.getRanking() + ": " + s.getInterpreter() + " "
//					+ s.getTitle());
//		}

		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();
			for (SongVO s : chartList) {
				JSONObject chart = new JSONObject();
				chart.put("interpreter", s.getInterpreter());
				chart.put("title", s.getTitle());
				chart.put("tracklength", s.getTracklength());
				chart.put("video", s.getVideo());
				chart.put("rating", s.getRating());
				chart.put("picture", s.getPicture());
				chart.put("ranking", s.getRanking());
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

			response.setContentType("application/json");
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
