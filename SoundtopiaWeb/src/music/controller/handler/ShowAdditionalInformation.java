package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.data.SongAdditionVO;
import music.manager.SongManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

public class ShowAdditionalInformation {
       
    public ShowAdditionalInformation() {
        super();
    }
	
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String view = null;		
		SongManagerLocal songManager = (SongManagerLocal)ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);
		int songID = Integer.valueOf(request.getParameter("songID"));
		SongAdditionVO songAddition = songManager.getSongInformation(songID);
		
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
