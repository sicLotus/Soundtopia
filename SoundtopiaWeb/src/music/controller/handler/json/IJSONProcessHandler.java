package music.controller.handler.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.handler.IRequestHandler;

public interface IJSONProcessHandler extends IRequestHandler {
	public void processJSON(HttpServletRequest request, HttpServletResponse response);
}
