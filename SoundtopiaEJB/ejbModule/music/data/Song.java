package music.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQueries ( {
@NamedQuery(
        name="song.findByInterpreterAndTitle",
        query="SELECT s FROM Song s WHERE s.interpreter LIKE :interpreter AND s.title LIKE :title"
),
@NamedQuery(
		name="song.findSearchResults",
		query="SELECT s FROM Song s JOIN s.songInCharts c LEFT JOIN s.songAddition sa where c.id.chartID = :chartID AND " +
		"( s.interpreter LIKE :search OR s.title LIKE :search OR sa.interpreter LIKE :search OR sa.title LIKE :search ) "
),
@NamedQuery(
		name="song.findSongsInChart",
		query="SELECT s FROM Song s JOIN s.songInCharts c where c.id.chartID = :chartID AND c.ranking >= :start AND c.ranking <= :end ORDER BY c.ranking")
})
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Temporal( TemporalType.DATE)
	private Date date;

	private String interpreter;

	private String picture;

	private float rating;

	private String title;

	private int tracklength;

	private String video;

	private int voteCount;

	private int voteTotal;

	//bi-directional many-to-one association to Price
	@OneToMany(mappedBy="song", fetch=FetchType.EAGER)
	@OrderBy("provider ASC")
	private Set<Price> prices;

	//bi-directional one-to-one association to Lyric
	@OneToOne
	@JoinColumn(name="id")
	private Lyric lyric;

	@OneToOne
	@JoinColumn(name="id")
	private SongAddition songAddition;
	
	
	//bi-directional many-to-one association to SongInChart
	@OneToMany(mappedBy="song", fetch=FetchType.EAGER)
	private Set<SongInChart> songInCharts;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="song", fetch=FetchType.EAGER)
	private Set<Rating> ratings;

    public Song() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInterpreter() {
		return this.interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTracklength() {
		return this.tracklength;
	}

	public void setTracklength(int tracklength) {
		this.tracklength = tracklength;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getVoteCount() {
		return this.voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getVoteTotal() {
		return this.voteTotal;
	}

	public void setVoteTotal(int voteTotal) {
		this.voteTotal = voteTotal;
	}

	public Set<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}
	
	public Lyric getLyric() {
		return this.lyric;
	}

	public void setLyric(Lyric lyric) {
		this.lyric = lyric;
	}
	
	public Set<SongInChart> getSongInCharts() {
		return this.songInCharts;
	}

	public void setSongInCharts(Set<SongInChart> songInCharts) {
		this.songInCharts = songInCharts;
	}
	
	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public SongAddition getSongAddition() {
		return songAddition;
	}

	public void setSongAddition(SongAddition songAddition) {
		this.songAddition = songAddition;
	}
	
	@Transient
	public String getChangedPicture() {
		String result = null;
		
		if (songAddition != null)
			result = this.songAddition.getCover();
		
		if (result == null)
			result = this.getPicture();
		
		return result;
	}
	
	@Transient
	public String getChangedInterpreter() {
		String result = null;
		
		if (songAddition != null)
			result = this.songAddition.getInterpreter();
		
		if (result == null)
			result = this.getInterpreter();
		
		return result;
	}
	
	@Transient
	public String getChangedTitle() {
		String result = null;
		
		if (songAddition != null)
			result = this.songAddition.getTitle();
		
		if (result == null)
			result = this.getTitle();
		
		return result;
	}
	
	
}