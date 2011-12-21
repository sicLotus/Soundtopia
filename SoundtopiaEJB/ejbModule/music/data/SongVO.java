package music.data;

import java.util.List;

public class SongVO {
	private int id;
	private String interpreter;
	private String title;
	private String tracklength;
	private String video;
	private float rating;
	private String picture;
	private List<PriceVO> prices;
	private LyricVO lyric;
	private int ranking;
	private Integer change;
	private int userRating;
	
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
	public String getTracklength() {
		return tracklength;
	}
	public void setTracklength(String tracklength) {
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
	public Integer getChange() {
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	public int getUserRating() {
		return userRating;
	}
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
