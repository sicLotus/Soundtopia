package music.controller.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.controller.ManagerFactory;
import music.data.PriceVO;
import music.data.SongVO;
import music.manager.SongManagerLocal;
import music.util.JSONException;
import music.util.JSONObject;

public class UndoChangesHandler {

    public UndoChangesHandler() {
        super();
    }

  
	public String processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		SongManagerLocal songManager = (SongManagerLocal)ManagerFactory.getManager("SongManager", ManagerFactory.Mode.Local);

		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(
				Locale.GERMAN);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
		
		int songID = Integer.valueOf(request.getParameter("songID"));
		SongVO song = songManager.undoChanges(songID);
		song = songManager.getSong(songID);
		System.out.println(song.getInterpreter());
		
		songManager.readNewSongInformationFromAPIs(songID, song.getInterpreter(), song.getTitle());
		
		song = songManager.getSong(songID);
		
		
		try {
			JSONObject json = new JSONObject();
			PrintWriter out;
			out = response.getWriter();

			json.put("title", song.getTitle());
			json.put("interpreter", song.getInterpreter());
			json.put("cover", song.getPicture());
		
			for (PriceVO p : song.getPrices()) {
				JSONObject prices = new JSONObject();
				prices.put("provider", p.getProvider());
				prices.put("url", p.getUrl());
				prices.put("value", df.format(p.getValue()));
				prices.put("currency", p.getCurrency());
				json.append("prices", prices);
			}

			JSONObject lyric = new JSONObject();
			lyric.put("text", song.getLyric().getText());
			lyric.put("url", song.getLyric().getUrl());
			json.put("lyric", lyric);

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
