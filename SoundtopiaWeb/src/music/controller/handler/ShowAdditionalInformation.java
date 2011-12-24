package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.Controller;
import music.data.SongAdditionVO;
import music.util.JSONException;
import music.util.JSONObject;

/**
 * Servlet implementation class ShowAdditionalInformation
 */
@WebServlet("/ShowAdditionalInformation")
public class ShowAdditionalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdditionalInformation() {
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
		int songID = Integer.valueOf(request.getParameter("songID"));
		SongAdditionVO songAddition = Controller.songManager.getSongInformation(songID);
		
		try {
			JSONObject json = new JSONObject();
			JSONObject songAdditionObject = new JSONObject();
			PrintWriter out;
			out = response.getWriter();
			songAdditionObject.put("cover", songAddition.getCover());
			songAdditionObject.put("interpreter", songAddition.getInterpreter());
			songAdditionObject.put("title", songAddition.getTitle());
			json.put("songAddition", songAdditionObject);	
			response.setContentType("application/json");
			out.println(json);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		return view;
	}

}
