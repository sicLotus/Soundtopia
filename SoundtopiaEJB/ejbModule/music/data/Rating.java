package music.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RatingPK id;

	private int rating;

	//bi-directional many-to-one association to Song
    @ManyToOne
	@JoinColumn(name="songID", insertable = false, updatable = false)
	private Song song;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="userID", insertable = false, updatable = false)
	private User user;

    public Rating() {
    }

	public RatingPK getId() {
		return this.id;
	}

	public void setId(RatingPK id) {
		this.id = id;
	}
	
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}