package music.data;
 

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the song_in_chart database table.
 * 
 */
@Entity
@Table(name="song_in_chart")
@NamedQuery(
		name="songInChart.findByIds",
		query="SELECT s FROM SongInChart s WHERE s.id = :id"
		)
public class SongInChart implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SongInChartPK id;

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
