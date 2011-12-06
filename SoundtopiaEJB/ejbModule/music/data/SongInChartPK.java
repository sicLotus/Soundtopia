package music.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the song_in_chart database table.
 * 
 */
@Embeddable
public class SongInChartPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int songID;

	private int chartID;

    public SongInChartPK() {
    }
	public int getSongID() {
		return this.songID;
	}
	public void setSongID(int songID) {
		this.songID = songID;
	}
	public int getChartID() {
		return this.chartID;
	}
	public void setChartID(int chartID) {
		this.chartID = chartID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SongInChartPK)) {
			return false;
		}
		SongInChartPK castOther = (SongInChartPK)other;
		return 
			(this.songID == castOther.songID)
			&& (this.chartID == castOther.chartID);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.songID;
		hash = hash * prime + this.chartID;
		
		return hash;
    }
}