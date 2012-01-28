package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ShowUserChartsHelper;

public class ShowUserChartsHandlerForward implements IForwardHandler {

	public ShowUserChartsHandlerForward() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		ShowUserChartsHelper helper = new ShowUserChartsHelper(request, response);

		if (!helper.getChartList().isEmpty() || helper.getChartList() != null) {
			request.setAttribute("chartList", helper.getChartList());
		}
		return "../views/topusercharts.jsp";
	}
}
