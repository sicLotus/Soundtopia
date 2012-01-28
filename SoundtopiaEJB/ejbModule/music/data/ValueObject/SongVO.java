package music.data.ValueObject;

import java.util.List;
import java.util.Set;

import music.data.DataObject.Lyric;
import music.data.DataObject.Price;
import music.data.DataObject.Song;
import music.util.Formatter;

public class SongVO {
	private int id;
	private String interpreter;
	private String title;
	private String tracklength;
	private String video;
	private float rating;
	private String cover;
	private List<PriceVO> prices;
	private LyricVO lyric;
	private int ranking;
	private Integer change;
	private int userRating;
	private int voteCount;

	public SongVO(String interpreter, String title, String cover) {
		super();
		this.interpreter = interpreter;
		this.title = title;
		this.cover = cover;
	}

	public SongVO() {
	}

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

	private void setTracklength(int tracklength) {
		setTracklength(Formatter.formatTime(tracklength));
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public List<PriceVO> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceVO> prices) {
		this.prices = prices;
	}

	private void setPrices(Set<Price> prices) {
		setPrices(PriceVO.valueOf(prices));
	}

	public LyricVO getLyric() {
		return lyric;
	}

	public void setLyric(LyricVO lyric) {
		this.lyric = lyric;
	}

	private void setLyric(Lyric lyric) {
		setLyric(LyricVO.valueOf(lyric));
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

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public static SongVO valueOf(Song song) {
		SongVO songVO = new SongVO();
		if (song != null) {
			songVO.setId(song.getId());
			songVO.setInterpreter(song.getChangedInterpreter());
			songVO.setTitle(song.getChangedTitle());
			songVO.setCover(song.getChangedCover());
			songVO.setRating(song.getRating());
			songVO.setVideo(song.getVideo());
			songVO.setTracklength(song.getTracklength());
			songVO.setVoteCount(song.getVoteCount());
			songVO.setLyric(song.getLyric());
			songVO.setPrices(song.getPrices());
			return songVO;
		} else
			return null;
	}

}
