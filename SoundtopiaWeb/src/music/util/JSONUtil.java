package music.util;

import java.util.List;

import music.data.ValueObject.LyricVO;
import music.data.ValueObject.PriceVO;
import music.data.ValueObject.SongAdditionVO;
import music.data.ValueObject.SongVO;
import music.data.ValueObject.UserVO;
import music.util.json.JSONException;
import music.util.json.JSONObject;

public class JSONUtil {

	public static JSONObject putChart(JSONObject json, List<SongVO> songList) throws JSONException {
		JSONObject chart = new JSONObject();
		for (SongVO s : songList) {
			chart = JSONUtil.appendSong(chart, s);
		}
		json.put("chart", chart);
		return json;
	}

	public static JSONObject appendSong(JSONObject chart, SongVO s) throws JSONException {
		JSONObject song = getSong(s);
		chart.append("song", song);
		return chart;
	}

	public static JSONObject putSong(JSONObject json, SongVO s) throws JSONException {
		JSONObject song = getSong(s);
		json.put("song", song);
		return json;
	}

	private static JSONObject getSong(SongVO s) throws JSONException {
		JSONObject song = new JSONObject();
		song.put("id", s.getId());
		song.put("interpreter", s.getInterpreter());
		song.put("title", s.getTitle());
		song.put("tracklength", s.getTracklength());
		song.put("video", s.getVideo());
		song.put("cover", s.getCover());
		song.put("ranking", s.getRanking());
		song.put("rating", Formatter.getNumberFormat().format(s.getRating()));
		song.put("userRating", Formatter.getNumberFormat().format(s.getUserRating()));
		song.put("voteCount", s.getVoteCount());
		song.put("change", s.getChange());
		song = putLyric(song, s.getLyric());
		song = putPrices(song, s.getPrices());
		return song;
	}

	public static JSONObject putURL(JSONObject json, String url) throws JSONException {
		return json.put("url", url);
	}

	public static JSONObject putLoggedIn(JSONObject json, Boolean loggedIn) throws JSONException {
		System.out.println("put logged in to json");
		return json.put("loggedIn", loggedIn);
	}

	public static JSONObject putSearchResults(JSONObject json, String searchResult) throws JSONException {
		return json.put("searchResults", searchResult);
	}

	public static JSONObject putRating(JSONObject json, int votes, float meanRate) throws JSONException {
		JSONObject rating = new JSONObject();
		rating.put("meanRating", Formatter.getNumberFormat().format(meanRate));
		rating.put("voteCount", votes);
		json.put("rating", rating);
		return json;
	}

	public static JSONObject putSongAddition(JSONObject json, SongAdditionVO songAddition) throws JSONException {
		JSONObject songAdditionObject = new JSONObject();
		songAdditionObject.put("cover", songAddition.getCover());
		songAdditionObject.put("interpreter", songAddition.getInterpreter());
		songAdditionObject.put("title", songAddition.getTitle());
		json.put("songAddition", songAdditionObject);
		return json;
	}

	public static JSONObject putPrices(JSONObject chart, List<PriceVO> priceList) throws JSONException {
		JSONObject price;
		for (PriceVO p : priceList) {
			price = new JSONObject();
			price = JSONUtil.putPrice(price, p);
			chart.append("prices", price);
		}
		return chart;
	}

	public static JSONObject putPrice(JSONObject price, PriceVO p) throws JSONException {
		price.put("provider", p.getProvider());
		price.put("url", p.getUrl());
		price.put("value", Formatter.getNumberFormat().format(p.getValue()));
		price.put("currency", p.getCurrency());
		return price;
	}

	public static JSONObject putLyric(JSONObject chart, LyricVO lyric) throws JSONException {
		JSONObject jsonLyric = new JSONObject();
		jsonLyric.put("text", lyric.getText());
		jsonLyric.put("url", lyric.getUrl());
		chart.put("lyric", jsonLyric);
		return chart;
	}

	public static JSONObject putUser(JSONObject json, UserVO user) throws JSONException {
		if (user != null) {
			System.out.println("put user to json");
			JSONObject userJSON = new JSONObject();
			userJSON.put("email", user.getEmail());
			userJSON.put("password", user.getPassword());
			userJSON.put("admin", user.getAdmin());
			json.put("user", userJSON);
		}
		return json;
	}

	public static JSONObject putNext(JSONObject json, int start, int end, int n, int chartAnz) throws JSONException {
		if (start + n <= chartAnz) {
			JSONObject next = new JSONObject();
			next.put("start", start + n);
			next.put("end", end + n);
			json.put("next", next);
		}
		return json;
	}

	public static JSONObject putPrev(JSONObject json, int start, int end, int n) throws JSONException {
		if (start - n > 0) {
			JSONObject prev = new JSONObject();
			prev.put("start", start - n);
			prev.put("end", end - n);
			json.put("prev", prev);
		}
		return json;
	}
}
