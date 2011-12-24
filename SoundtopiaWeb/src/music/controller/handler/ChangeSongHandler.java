package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.data.PriceVO;
import music.data.SongVO;
import music.util.JSONException;
import music.util.JSONObject;

/**
 * Servlet implementation class ChangeSongHandler
 */
@WebServlet("/ChangeSongHandler")
public class ChangeSongHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeSongHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;

		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

		String interpreter = request.getParameter("interpreter");
		String title = request.getParameter("title");
		String cover = request.getParameter("cover");
		int songID = Integer.valueOf(request.getParameter("songID"));

		SongVO song = Controller.songManager.changeSongInformation(songID,
				interpreter, title, cover);
		song = Controller.songManager.getSong(songID);

		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();

			json.put("title", song.getTitle());
			json.put("interpreter", song.getInterpreter());
			json.put("cover", song.getPicture());
		
			for (PriceVO p : song.getPrices()) {
				System.out.println("price gefunden");
				JSONObject prices = new JSONObject();
				prices.put("provider", p.getProvider());
				prices.put("url", p.getUrl());
				prices.put("value", df.format(p.getValue()));
				prices.put("currency", p.getCurrency());
				json.append("prices", prices);
			}

			JSONObject lyric = new JSONObject();
			lyric.put("text", song.getLyric().getText());
			lyric.put("url", song.getLyric().getUrl());
			json.put("lyric", lyric);

			response.setContentType("application/json");
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}

		return view;
	}

}
