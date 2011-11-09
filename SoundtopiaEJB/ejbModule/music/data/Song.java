package music.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    @Temporal( TemporalType.DATE)
	private Date date;

	private String interpreter;

	private String picture;

	private float price7digital;

	private float priceAmazon;

	private float priceItunes;

	private float rating;

	private String title;

	private int tracklength;

	private String video;

	private int voteCount;

	private int voteTotal;

	//bi-directional many-to-many association to Chart
	@ManyToMany(mappedBy="songs", fetch=FetchType.EAGER)
	private Set<Chart> charts;

	//bi-directional one-to-one association to Lyric
	@OneToOne(mappedBy="song")
	private Lyric lyric;

	//bi-directional many-to-many association to User
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="rating"
		, joinColumns={
			@JoinColumn(name="songID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="userID")
			}
		)
	private List<User> users;

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

	public float getPrice7digital() {
		return this.price7digital;
	}

	public void setPrice7digital(float price7digital) {
		this.price7digital = price7digital;
	}

	public float getPriceAmazon() {
		return this.priceAmazon;
	}

	public void setPriceAmazon(float priceAmazon) {
		this.priceAmazon = priceAmazon;
	}

	public float getPriceItunes() {
		return this.priceItunes;
	}

	public void setPriceItunes(float priceItunes) {
		this.priceItunes = priceItunes;
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

	public Set<Chart> getCharts() {
		return this.charts;
	}

	public void setCharts(Set<Chart> charts) {
		this.charts = charts;
	}
	
	public Lyric getLyric() {
		return this.lyric;
	}

	public void setLyric(Lyric lyric) {
		this.lyric = lyric;
	}
	
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}