package music.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the charts database table.
 * 
 */
@Entity
@Table(name="charts")
public class Chart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	private Date lastUpdated;

	private String name;

	//bi-directional many-to-one association to SongInChart
	@OneToMany(mappedBy="chart", fetch=FetchType.EAGER)
	private Set<SongInChart> songInCharts;

    public Chart() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SongInChart> getSongInCharts() {
		return this.songInCharts;
	}

	public void setSongInCharts(Set<SongInChart> songInCharts) {
		this.songInCharts = songInCharts;
	}
	
}