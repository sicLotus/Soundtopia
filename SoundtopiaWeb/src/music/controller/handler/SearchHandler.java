package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.manager.ChartManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

public class SearchHandler {


    public SearchHandler() {
        super();
    }
	
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		ChartManagerLocal chartManager = (ChartManagerLocal) ManagerFactory.getManager("ChartManager", ManagerFactory.Mode.Local);
		String searchStr = request.getParameter("searchinput");
		
		String[] search = searchStr.split(",");
		
		String searchResult = chartManager.suggestSearch(search, "Singlecharts");
		
		try {
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("searchResults", searchResult);
			response.setContentType("application/json");
			out.println(json);
		}
		 catch (JSONException e) {
			 e.printStackTrace();
		 }
		
		return view;
	}
}
