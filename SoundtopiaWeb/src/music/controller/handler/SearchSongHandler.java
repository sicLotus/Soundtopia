package music.controller.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.data.SongVO;
import music.data.UserVO;
import music.manager.ChartManagerLocal;

public class SearchSongHandler {

	public SearchSongHandler() {
		super();
	}

	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		String searchStr = request.getParameter("searchinput");
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		int userID = -1;
		searchStr = searchStr.replaceAll("\\p{Punct}", "");
		String[] search = searchStr.split(" ");
		
		List<SongVO> results;
		
		if (user != null)
			userID = user.getId(); 
			
		results = chartManager.searchSongs(
				userID, search, "Singlecharts");
		
		if (results.isEmpty() || results == null) {
			view = "../error/noSearchResult.jsp";
		}
		else {
			request.setAttribute("chartList", results);
			view = "../views/searchResults.jsp";
		}
		
		return view;
	}
}
