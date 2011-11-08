package music.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the charts database table.
 * 
 */
@Entity
@Table(name="charts")
public class Chart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	private Date lastUpdated;

	private String name;

	//bi-directional many-to-many association to Song
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="song_in_chart"
		, joinColumns={
			@JoinColumn(name="chartID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="songID")
			}
		)
	private List<Song> songs;

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

	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}