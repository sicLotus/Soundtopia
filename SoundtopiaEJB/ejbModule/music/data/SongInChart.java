package music.data;
 

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the song_in_chart database table.
 * 
 */
@Entity
@Table(name="song_in_chart")
public class SongInChart implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SongInChartPK id;

    @Temporal( TemporalType.DATE)
	private Date added;

	private int ranking;

	//bi-directional many-to-one association to Chart
    @ManyToOne
	@JoinColumn(name="chartID", insertable = false, updatable = false)
	private Chart chart;

	//bi-directional many-to-one association to Song
    @ManyToOne
	@JoinColumn(name="songID", insertable = false, updatable = false)
	private Song song;

    public SongInChart() {
    }

	public SongInChartPK getId() {
		return this.id;
	}

	public void setId(SongInChartPK id) {
		this.id = id;
	}
	
	public Date getAdded() {
		return this.added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public int getRanking() {
		return this.ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Chart getChart() {
		return this.chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}
	
	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
}
