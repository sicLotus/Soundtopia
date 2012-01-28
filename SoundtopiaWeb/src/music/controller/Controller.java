package music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.handler.IRequestHandler;
import music.controller.handler.forward.IForwardHandler;
import music.controller.handler.forward.LoginHandler;
import music.controller.handler.forward.LogoutHandler;
import music.controller.handler.forward.RegisterHandler;
import music.controller.handler.forward.SearchSongHandler;
import music.controller.handler.forward.ShowChartsHandlerForward;
import music.controller.handler.forward.ShowMyChartsHandler;
import music.controller.handler.forward.ShowUserChartsHandlerForward;
import music.controller.handler.json.ChangeSongHandler;
import music.controller.handler.json.IJSONProcessHandler;
import music.controller.handler.json.PictureHandler;
import music.controller.handler.json.RateSongHandler;
import music.controller.handler.json.ReadChartsHandler;
import music.controller.handler.json.SearchSuggestHandler;
import music.controller.handler.json.ShowAdditionalInformation;
import music.controller.handler.json.ShowChartsHandlerJSON;
import music.controller.handler.json.ShowUserChartsHandlerJSON;
import music.controller.handler.json.UndoChangesHandler;
import music.exception.SoundtopiaException;
import music.util.SessionUtil;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShowChartsHandlerJSON showChartsHandlerJSON;
	private ShowChartsHandlerForward showChartsHandlerForward;
	private ShowUserChartsHandlerJSON showUserChartsHandlerJSON;
	private ShowUserChartsHandlerForward showUserChartsHandlerForward;
	private RegisterHandler registerHandler;
	private LoginHandler loginHandler;
	private RateSongHandler rateSongHandler;
	private LogoutHandler logoutHandler;
	private ShowAdditionalInformation showAdditionalInformationHandler;
	private ChangeSongHandler changeSongHandler;
	private PictureHandler pictureHandler;
	private UndoChangesHandler undoChangesHandler;
	private ReadChartsHandler readChartsHandler;
	private SearchSuggestHandler searchSuggestHandler;
	private SearchSongHandler searchSongHandler;
	private ShowMyChartsHandler showMyChartsHandler;
	ServletConfig servletConfig;

	public Controller() {
		super();
		showChartsHandlerJSON = new ShowChartsHandlerJSON();
		showChartsHandlerForward = new ShowChartsHandlerForward();
		showUserChartsHandlerJSON = new ShowUserChartsHandlerJSON();
		showUserChartsHandlerForward = new ShowUserChartsHandlerForward();
		registerHandler = new RegisterHandler();
		loginHandler = new LoginHandler();
		rateSongHandler = new RateSongHandler();
		logoutHandler = new LogoutHandler();
		showAdditionalInformationHandler = new ShowAdditionalInformation();
		changeSongHandler = new ChangeSongHandler();
		pictureHandler = new PictureHandler();
		undoChangesHandler = new UndoChangesHandler();
		readChartsHandler = new ReadChartsHandler();
		searchSuggestHandler = new SearchSuggestHandler();
		searchSongHandler = new SearchSongHandler();
		showMyChartsHandler = new ShowMyChartsHandler();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			processRequest(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			processRequest(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initializeSession(HttpSession session) {
		if (session.getAttribute("loggedIn") == null)
			SessionUtil.setLoggedIn(session, new Boolean(false));
		if (session.getAttribute("lastVisitSong") == null)
			SessionUtil.setLastVisitSong(session, 1);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		String pathInfo = request.getPathInfo();

		HttpSession session = request.getSession();

		initializeSession(session);

		String commandHandler = getPathInfo(response, pathInfo);
		System.out.println("pathinfo = " + pathInfo);
		System.out.println("servlet = " + commandHandler);
		String view = null;

		IRequestHandler requestHandler = getRequestHandler(request, response, commandHandler);
		try {
			if (requestHandler instanceof IForwardHandler) {
				view = ((IForwardHandler) requestHandler).getForward(request, response);
			} else {
				((IJSONProcessHandler) requestHandler).processJSON(request, response);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			String[] msg = e.getMessage().split(":");
			if (msg.length > 1)
				request.setAttribute("errorMsg", msg[1]);
			else request.setAttribute("errorMsg", e.getMessage());
			view = "/error/err.jsp";
		}

		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}

	}
	private IRequestHandler getRequestHandler(HttpServletRequest request, HttpServletResponse response, String commandHandler) throws ServletException, IOException {
		if (commandHandler.equals("register")) {
			return registerHandler;
		} else if (commandHandler.equals("login")) {
			return loginHandler;
		} else if (commandHandler.equals("showCharts")) {
			return getShowChartsHandler(request);
		} else if (commandHandler.equals("rateSong")) {
			return rateSongHandler;
		} else if (commandHandler.equals("logout")) {
			return logoutHandler;
		} else if (commandHandler.equals("showInfo")) {
			return showAdditionalInformationHandler;
		} else if (commandHandler.equals("changeSongInformation")) {
			return changeSongHandler;
		} else if (commandHandler.equals("getPictureURL")) {
			return pictureHandler;
		} else if (commandHandler.equals("undoChanges")) {
			return undoChangesHandler;
		} else if (commandHandler.equals("readNewCharts")) {
			return readChartsHandler;
		} else if (commandHandler.equals("suggestSearch")) {
			return searchSuggestHandler;
		} else if (commandHandler.equals("searchSongs")) {
			return searchSongHandler;
		} else if (commandHandler.equals("showUserCharts")) {
			return getShowUserChartsHandler(request);
		} else if (commandHandler.equals("showMyCharts")) {
			return showMyChartsHandler;
		} else
			 throw new SoundtopiaException("Ihre Seite konnte nicht gefunden werden.");

	}

	private IRequestHandler getShowUserChartsHandler(HttpServletRequest request) {
		if (request.getParameter("mode") != null)
			return showUserChartsHandlerJSON;
		else
			return showUserChartsHandlerForward;
	}

	private IRequestHandler getShowChartsHandler(HttpServletRequest request) {
		try {
			if (request.getParameter("op").equals("update")) {
				return showChartsHandlerJSON;
			}
		} catch (NullPointerException e) {

		}
		return showChartsHandlerForward;

	}

	private String getPathInfo(HttpServletResponse response, String pathInfo) throws IOException {
		if (pathInfo == null || pathInfo.equals("/"))
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

		String servlet = pathInfo.substring(1);
		return servlet;
	}
}
