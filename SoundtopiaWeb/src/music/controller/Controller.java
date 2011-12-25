package music.controller;

import java.io.IOException;

import javax.ejb.EJB;
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
import music.controller.handler.RegisterHandler;
import music.controller.handler.ShowAdditionalInformation;
import music.controller.handler.ShowChartsHandler;
import music.controller.handler.UndoChangesHandler;
import music.manager.ChartManagerLocal;
import music.manager.SessionLocal;
import music.manager.SongManagerLocal;
import music.manager.UserManagerLocal;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	public static UserManagerLocal userManager;
	
	@EJB
	public static ChartManagerLocal chartManager;
	
	@EJB
	public static SongManagerLocal songManager;
	
	@EJB
	public static SessionLocal sessionManager;
/*
//EJB injezieren
	@EJB UserDAO userHelper;
	@EJB BookDAO bookHelper;
	@EJB GenreDAO genreHelper;
	@EJB VerlagDAO verlagHelper;
	@EJB CoverDAO coverHelper;
	@EJB VerkaufslisteDAO verkaufslisteHelper;
	
	@PersistenceUnit
	EntityManagerFactory emf;
	
	private UserBO userBO;
	private BookBO bookBO;
	private StoreBO storeBO;
 */      
// Constructor
// ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯
    public Controller() {
        super();
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
		if (session.getAttribute("loggedIn") == null) {
			session.setAttribute("loggedIn", new Boolean(false));
		}
	}
	
	/*	
	private void initializeSession(HttpSession session) {
		if (session.getAttribute("userBO") == null) {
			userBO = new UserBO(userHelper);
			session.setAttribute("userBO", userBO);
		}

		if (session.getAttribute("bookBO") == null) {
			bookBO = new BookBO(bookHelper, genreHelper, verlagHelper,
					coverHelper);
			session.setAttribute("bookBO", bookBO);
		}

		if (session.getAttribute("storeBO") == null) {
			storeBO = new StoreBO(bookHelper, verkaufslisteHelper);
			session.setAttribute("storeBO", storeBO);
		}

		if (session.getAttribute("cart") == null) {
			Cart cart = new Cart();
			session.setAttribute("cart", cart);
		}

		if (session.getAttribute("bookList") == null) {
			List<Book> bookList = new ArrayList<Book>();
			session.setAttribute("bookList", bookList);
		}

		if (session.getAttribute("coverList") == null) {
			List<Cover> coverList = new ArrayList<Cover>();
			coverList = bookBO.getCovers();
			session.setAttribute("coverList", coverList);
		}

		if (session.getAttribute("genreList") == null) {
			List<Genre> genreList = new ArrayList<Genre>();
			genreList = bookBO.getGenres();
			session.setAttribute("genreList", genreList);
		}

		if (session.getAttribute("verlagList") == null) {
			List<Verlag> verlagList = new ArrayList<Verlag>();
			verlagList = bookBO.getPublisher();
			session.setAttribute("verlagList", verlagList);
		}
	}
	*/
	
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
			RegisterHandler handler = new RegisterHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("login")){
			LoginHandler handler = new LoginHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("showCharts")){
			ShowChartsHandler handler = new ShowChartsHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("rateSong")){
			RateSongHandler handler = new RateSongHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("logout")){
			LogoutHandler handler = new LogoutHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("showInfo")){
			ShowAdditionalInformation handler = new ShowAdditionalInformation();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("changeSongInformation")){
			ChangeSongHandler handler = new ChangeSongHandler();
			view = handler.processRequest(request, response);
		}
	
		if(servlet.equals("getPictureURL")){
			PictureHandler handler = new PictureHandler();
			view = handler.processRequest(request, response);
		}
			
		if(servlet.equals("undoChanges")){
			UndoChangesHandler handler = new UndoChangesHandler();
			view = handler.processRequest(request, response);
		}
/*		
		if(servlet.equals("addBook")){
			AddBookHandler handler = new AddBookHandler();
			view = handler.processRequest(request, response);
		}
		
		if(servlet.equals("addGenre")){
			AddGenreHandler handler = new AddGenreHandler();
			handler.processRequest(request, response);
			view = null;
		}
		
		if(servlet.equals("addVerlag")){
			AddVerlagHandler handler = new AddVerlagHandler();
			handler.processRequest(request, response);
			view = null;
		}
		
		
		
		if(servlet.equals("uploadPicture")){
			UploadHandler handler = new UploadHandler();
			view = handler.processRequest(request, response);		
		}
		
		if(servlet.equals("cart")){
			CartHandler handler = new CartHandler();
			view = handler.processRequest(request, response);		
		}
		
		if(servlet.equals("editBook")){
			EditBookHandler handler = new EditBookHandler();
			view = handler.processRequest(request, response);		
		}
		
		*/
		if (view != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}			
	}
}
