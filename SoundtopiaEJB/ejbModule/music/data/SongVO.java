package music.data;

import java.util.List;

public class SongVO {
	private String interpreter;
	private String title;
	private int tracklength;
	private String video;
	private float rating;
	private String picture;
	private List<PriceVO> prices;
	private LyricVO lyric;
	private int ranking;
	
	public String getInterpreter() {
		return interpreter;
	}
	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTracklength() {
		return tracklength;
	}
	public void setTracklength(int tracklength) {
		this.tracklength = tracklength;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<PriceVO> getPrices() {
		return prices;
	}
	public void setPrices(List<PriceVO> prices) {
		this.prices = prices;
	}
	public LyricVO getLyric() {
		return lyric;
	}
	public void setLyric(LyricVO lyric) {
		this.lyric = lyric;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
