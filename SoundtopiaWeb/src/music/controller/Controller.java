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

import music.controller.handler.ChangeSongHandler;
import music.controller.handler.LoginHandler;
import music.controller.handler.LogoutHandler;
import music.controller.handler.PictureHandler;
import music.controller.handler.RateSongHandler;
import music.controller.handler.ReadChartsHandler;
import music.controller.handler.RegisterHandler;
import music.controller.handler.SearchHandler;
import music.controller.handler.SearchSongHandler;
import music.controller.handler.ShowAdditionalInformation;
import music.controller.handler.ShowChartsHandler;
import music.controller.handler.ShowMyChartsHandler;
import music.controller.handler.ShowUserChartsHandler;
import music.controller.handler.UndoChangesHandler;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ShowChartsHandler showChartsHandler;
	private RegisterHandler registerHandler;
	private LoginHandler loginHandler;
	private RateSongHandler rateSongHandler;
	private	LogoutHandler logoutHandler;
	private ShowAdditionalInformation showAdditionalInformationHandler;
	private ChangeSongHandler changeSongHandler;
	private PictureHandler pictureHandler;
	private UndoChangesHandler undoChangesHandler;
	private ReadChartsHandler readChartsHandler;
	private SearchHandler searchHandler;
	private SearchSongHandler searchSongHandler;
	private ShowUserChartsHandler showUserChartsHandler;
	private ShowMyChartsHandler showMyChartsHandler;
	
// Constructor
// ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
    public Controller() {
        super();
        showChartsHandler = new ShowChartsHandler();
        registerHandler =  new RegisterHandler();
        loginHandler = new LoginHandler();
        rateSongHandler = new RateSongHandler();
        logoutHandler = new LogoutHandler();
        showAdditionalInformationHandler = new ShowAdditionalInformation();
        changeSongHandler = new ChangeSongHandler();
        pictureHandler = new PictureHandler();
        undoChangesHandler = new UndoChangesHandler();
        readChartsHandler = new ReadChartsHandler();
        searchHandler = new SearchHandler();
        searchSongHandler = new SearchSongHandler();
        showUserChartsHandler = new ShowUserChartsHandler();
        showMyChartsHandler = new ShowMyChartsHandler();
    }

// Methods
// ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    
    public void init() throws ServletException{
		super.init();
	}
	
    ServletConfig servletConfig; //instance variable
    public void init(ServletConfig config) throws ServletException {
    	servletConfig = config;
    	super.init();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
		try {	
			processRequest(request,response);		
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
		try {		
			processRequest(request,response);		
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
			session.setAttribute("loggedIn", new Boolean(false));
		
		if(session.getAttribute("lastVisitSong") == null) 
			session.setAttribute("lastVisitSong", 1);
				
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String pathInfo = request.getPathInfo();
		String view = null;
		
		HttpSession session = request.getSession();
		
		initializeSession(session);
				
		if (pathInfo == null || "/".equals(pathInfo))
			   response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		
		String servlet = pathInfo.substring(1);
		System.out.println("pathinfo = "+pathInfo);
		System.out.println("servlet = "+servlet);
		
		if(servlet.equals("register")){
			view = registerHandler.processRequest(request, response);
		}
		
		if(servlet.equals("login")){
			view = loginHandler.processRequest(request, response);
		}
		
		if(servlet.equals("showCharts")){
			view = showChartsHandler.processRequest(request, response);
		}
		
		if(servlet.equals("rateSong")){
			view = rateSongHandler.processRequest(request, response);
		}
		
		if(servlet.equals("logout")){
			view = logoutHandler.processRequest(request, response);
		}
		
		if(servlet.equals("showInfo")){
			view = showAdditionalInformationHandler.processRequest(request, response);
		}
		
		if(servlet.equals("changeSongInformation")){
			view = changeSongHandler.processRequest(request, response);
		}
	
		if(servlet.equals("getPictureURL")){
			view = pictureHandler.processRequest(request, response);
		}
			
		if(servlet.equals("undoChanges")){
			view = undoChangesHandler.processRequest(request, response);
		}
		
		if(servlet.equals("readNewCharts")){
			view = readChartsHandler.processRequest(request, response);
		}
		
		if(servlet.equals("suggestSearch")){
			view = searchHandler.processRequest(request, response);
		}
		
		if(servlet.equals("searchSongs")){
			view = searchSongHandler.processRequest(request, response);
		}
		
		if(servlet.equals("showUserCharts")){
			view = showUserChartsHandler.processRequest(request, response);		
		}
		
		if(servlet.equals("showMyCharts")){
			view = showMyChartsHandler.processRequest(request, response);		
		}

		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}			
	}
}
