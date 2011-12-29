package music.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	public SongVO valueOf(Song song) {
		if (song != null) {
			setId(song.getId());
			setInterpreter(song.getChangedInterpreter());
			setTitle(song.getChangedTitle());
			setPicture(song.getChangedPicture());
			setRating(song.getRating());
			setVideo(song.getVideo());
			setTracklength(convertToTime(song.getTracklength()));
			valueOf(song.getLyric());
			valueOf(song.getPrices());
			return this;
		}
		else return null;
	}

	private void valueOf(Lyric lyric) {
		if (lyric != null) {
			LyricVO lyricVO = new LyricVO();
			lyricVO.setText(lyric.getText());
			lyricVO.setUrl(lyric.getUrl());
			setLyric(lyricVO);
		}
	}

	private void valueOf(Set<Price> prices) {
		if (prices != null) {
			List<PriceVO> pricesVO = new ArrayList<PriceVO>();
			PriceVO priceVO;
			for (Price p : prices) {
				priceVO = new PriceVO();
				priceVO.setCurrency(p.getCurrency());
				priceVO.setProvider(p.getProvider());
				priceVO.setUrl(p.getOfferUrl());
				priceVO.setValue(p.getValue());
				pricesVO.add(priceVO);
			}
			setPrices(pricesVO);
		}
	}

	private String convertToTime(int sec) {
		String result;
		int minutes = sec / 60;
		int seconds = sec % 60;
		if (seconds < 10)
			result = minutes + ":0" + seconds;
		else
			result = minutes + ":" + seconds;
		return result;
	}

}
