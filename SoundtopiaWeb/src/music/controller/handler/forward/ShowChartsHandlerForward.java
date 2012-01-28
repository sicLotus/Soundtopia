package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.ShowChartsHelper;

public class ShowChartsHandlerForward implements IForwardHandler {

	public ShowChartsHandlerForward() {
		super();
	}

	@Override
	public String getForward(HttpServletRequest request, HttpServletResponse response) {
		ShowChartsHelper helper = new ShowChartsHelper(request, response);
		setPrevAndNextSite(request, helper);
		request.setAttribute("chartList", helper.getChartList());
		return "../views/charts.jsp";
	}

	private void setPrevAndNextSite(HttpServletRequest request, ShowChartsHelper showChartsHandler) {
		if (!isLastSite(showChartsHandler)) {
			setSongCountOnNextSite(request, showChartsHandler);
		}
		if (!isFirstSite(showChartsHandler)) {
			setSongCountOnPreviousSite(request, showChartsHandler);
		}
	}

	private void setSongCountOnPreviousSite(HttpServletRequest request, ShowChartsHelper showChartsHandler) {
		request.setAttribute("prevStart", showChartsHandler.getStart() - showChartsHandler.getSONGS_PER_SITE());
		request.setAttribute("prevEnd", showChartsHandler.getEnd() - showChartsHandler.getSONGS_PER_SITE());
	}

	private void setSongCountOnNextSite(HttpServletRequest request, ShowChartsHelper showChartsHandler) {
		request.setAttribute("nextStart", showChartsHandler.getStart() + showChartsHandler.getSONGS_PER_SITE());
		request.setAttribute("nextEnd", showChartsHandler.getEnd() + showChartsHandler.getSONGS_PER_SITE());
	}

	private boolean isFirstSite(ShowChartsHelper showChartsHandler) {
		return showChartsHandler.getStart() - showChartsHandler.getSONGS_PER_SITE() <= 0;
	}

	private boolean isLastSite(ShowChartsHelper showChartsHandler) {
		return showChartsHandler.getStart() + showChartsHandler.getSONGS_PER_SITE() > showChartsHandler.getChartAnz();
	}

}
