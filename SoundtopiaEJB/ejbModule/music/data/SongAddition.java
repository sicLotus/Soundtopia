package music.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the song_addition database table.
 * 
 */
@Entity
@Table(name="song_addition")
public class SongAddition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int songID;
	
	//bi-directional one-to-one association to Song
	@OneToOne(mappedBy="songAddition")
	private Song song;

	private String cover;

	private String interpreter;

	private String title;

    public SongAddition() {
    }

	public int getSongID() {
		return this.songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getInterpreter() {
		return this.interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}