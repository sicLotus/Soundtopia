package music.data;

import java.util.List;

import music.util.EntityDecoder;

public class ChartEntryVO {
	private String movie_title;
	private int movie_length;
	private String permalink;
	private String movie_url;
	
	//private int movie_id;
	//private String movie_thumbnail;
	//private int movie_owner_id;
	//private String movie_owner;
	//private String movie_owner_url;
	//private double movie_rating;
	//private int movie_views;
	//private int movie_added;
	//private String permathumblink;
	
	private int chartPlacing;
	private String title;
	private String interpreter;
	private String coverUrl;
	private LyricVO lyricVO;
	private List<PriceVO> priceVO;
	

	public void setMovie_title(String movie_title) {
		String[] delimiter = new String[] { " -- ", " - " };
		int index;
		this.movie_title = movie_title;

		for (String del : delimiter) {
			index = movie_title.indexOf(del);
			if (index >= 0) {
				setInterpreter(movie_title.substring(0, index));
				setTitle(movie_title.substring(index + del.length())
						.replaceAll("\\(.*\\)", "").replaceAll("Official HD.*", ""));
				break;
			} else {
				setInterpreter("");
				setTitle(movie_title);
			}
		}
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public int getChartPlacing() {
		return chartPlacing;
	}

	public void setChartPlacing(int chartPlacing) {
		this.chartPlacing = chartPlacing;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public LyricVO getLyricVO() {
		return lyricVO;
	}

	public void setLyricVO(LyricVO lyricVO) {
		this.lyricVO = lyricVO;
	}

	public List<PriceVO> getPriceVO() {
		return priceVO;
	}

	public void setPriceVO(List<PriceVO> priceVO) {
		this.priceVO = priceVO;
	}

	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = EntityDecoder.htmlToChar(interpreter);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = EntityDecoder.htmlToChar(title);
	}
	
	public String getMovie_title() {
		return movie_title;
	}
	
/*
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}



	public String getMovie_thumbnail() {
		return movie_thumbnail;
	}

	public void setMovie_thumbnail(String movie_thumbnail) {
		this.movie_thumbnail = movie_thumbnail;
	}*/

	public int getMovie_length() {
		return movie_length;
	}

	public void setMovie_length(int movie_length) {
		this.movie_length = movie_length;
	}

/*	public int getMovie_owner_id() {
		return movie_owner_id;
	}

	public void setMovie_owner_id(int movie_owner_id) {
		this.movie_owner_id = movie_owner_id;
	}

	public String getMovie_owner() {
		return movie_owner;
	}

	public void setMovie_owner(String movie_owner) {
		this.movie_owner = movie_owner;
	}

	public String getMovie_owner_url() {
		return movie_owner_url;
	}

	public void setMovie_owner_url(String movie_owner_url) {
		this.movie_owner_url = movie_owner_url;
	}

	public double getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(double movie_rating) {
		this.movie_rating = movie_rating;
	}

	public int getMovie_views() {
		return movie_views;
	}

	public void setMovie_views(int movie_views) {
		this.movie_views = movie_views;
	}

	public int getMovie_added() {
		return movie_added;
	}

	public void setMovie_added(int movie_added) {
		this.movie_added = movie_added;
	}*/

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

/*	public String getPermathumblink() {
		return permathumblink;
	}

	public void setPermathumblink(String permathumblink) {
		this.permathumblink = permathumblink;
	}*/

	public String getMovie_url() {
		return movie_url;
	}

	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;
	}

	public String toString() {
		/*
		 * return movie_id + "\n" + movie_title + '\n' + movie_thumbnail + '\n'
		 * + movie_length + '\n' + movie_owner_id + '\n' + movie_owner + '\n' +
		 * movie_owner_url + '\n' + movie_rating + '\n' + movie_views + '\n' +
		 * movie_added + '\n' + permalink + '\n' + permathumblink + '\n' +
		 * movie_url;
		 */

		return interpreter + "|" + title;

	}

}
