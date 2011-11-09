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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	private Set<Song> songs;

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

	public Set<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
}