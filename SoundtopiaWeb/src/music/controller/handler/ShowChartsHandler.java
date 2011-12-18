package music.controller.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.data.ChartEntryVO;
import music.data.SongVO;

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
			end = 20;
		}
		
		System.out.println("EJB: "+Controller.chartManager);
		chartList = Controller.chartManager.showCharts("Singlecharts", 1, 25);
		for(SongVO s : chartList) {
			System.out.println(s.getRanking()+": "+s.getInterpreter()+" "+s.getTitle());
		}
		

		request.setAttribute("chartList", chartList);

		view = "../views/charts.jsp";

		return view;
	}

}
