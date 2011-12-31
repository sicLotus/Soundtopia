package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.Controller;
import music.data.UserVO;
import music.util.JSONException;
import music.util.JSONObject;

/**
 * Servlet implementation class rateSong
 */
@WebServlet("/rateSong")
public class RateSongHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateSongHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String view = null;
		HttpSession session = request.getSession();
		
		if((Boolean)session.getAttribute("loggedIn") == true) {
			UserVO user = (UserVO) session.getAttribute("user");
			int songID = Integer.valueOf(request.getParameter("songID"));
			int rating = Integer.valueOf(request.getParameter("rating"));
			
			Controller.songManager.rateASong(user.getId(), songID, rating);
			DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
			otherSymbols.setDecimalSeparator('.');
			otherSymbols.setGroupingSeparator(','); 
			DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

			float meanRate = Controller.songManager.getMeanRate(songID);
			int votes = Controller.songManager.getVoteCount(songID);
			
			try {
				JSONObject json = new JSONObject();
				PrintWriter out;
				out = response.getWriter();
				json.put("meanRating", df.format(meanRate));
				json.put("voteCount", votes);
				response.setContentType("application/json");
				out.println(json);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			view = "noAccessErr.jsp";
		}
		
		return view;
		
	}

}
