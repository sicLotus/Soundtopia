package music.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rating database table.
 * 
 */
@Embeddable
public class RatingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int userID;

	private int songID;

    public RatingPK() {
    }
	public int getUserID() {
		return this.userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getSongID() {
		return this.songID;
	}
	public void setSongID(int songID) {
		this.songID = songID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RatingPK)) {
			return false;
		}
		RatingPK castOther = (RatingPK)other;
		return 
			(this.userID == castOther.userID)
			&& (this.songID == castOther.songID);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userID;
		hash = hash * prime + this.songID;
		
		return hash;
    }
}