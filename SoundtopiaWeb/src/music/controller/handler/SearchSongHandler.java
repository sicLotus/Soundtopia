package music.controller.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.data.SongVO;
import music.data.UserVO;


/**
 * Servlet implementation class SearchHandler
 */
@WebServlet("/SearchHandler")
public class SearchSongHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchSongHandler() {
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

		String searchStr = request.getParameter("searchinput");
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		int userID = -1;
		searchStr = searchStr.replaceAll("\\p{Punct}", "");
		String[] search = searchStr.split(" ");
		
		List<SongVO> results;
		
		if (user != null)
			userID = user.getId(); 
			
		results = Controller.chartManager.searchSongs(
				userID, search, "Singlecharts");

		System.out.println(results.size());
		
		if (!results.isEmpty() || results != null) {
			System.out.println("results gefunden");
			request.setAttribute("chartList", results);
			view = "../views/searchResults.jsp";
		}
		else view = "../error/noSearchResult.jsp";

		System.out.println(view);
		
		/*
		 * try { PrintWriter out = response.getWriter(); JSONObject json = new
		 * JSONObject(); json.put("searchResults", searchResult);
		 * response.setContentType("application/json"); out.println(json); }
		 * catch (JSONException e) { e.printStackTrace(); }
		 */

		return view;
	}
}
