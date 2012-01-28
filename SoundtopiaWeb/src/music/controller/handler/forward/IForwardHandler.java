package music.controller.handler.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.IRequestHandler;

public interface IForwardHandler extends IRequestHandler {
	public String getForward(HttpServletRequest request, HttpServletResponse response);
}
