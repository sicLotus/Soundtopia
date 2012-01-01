package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.controller.ManagerFactory;
import music.data.UserVO;
import music.manager.SongManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

public class RateSongHandler {
   
    public RateSongHandler() {
        super();
    }
	
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		SongManagerLocal songManager = (SongManagerLocal)ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);

		String view = null;
		HttpSession session = request.getSession();
		
		if((Boolean)session.getAttribute("loggedIn") == true) {
			UserVO user = (UserVO) session.getAttribute("user");
			int songID = Integer.valueOf(request.getParameter("songID"));
			int rating = Integer.valueOf(request.getParameter("rating"));
			
			songManager.rateASong(user.getId(), songID, rating);
			DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
			otherSymbols.setDecimalSeparator('.');
			otherSymbols.setGroupingSeparator(','); 
			DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

			float meanRate = songManager.getMeanRate(songID);
			int votes = songManager.getVoteCount(songID);
			
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
