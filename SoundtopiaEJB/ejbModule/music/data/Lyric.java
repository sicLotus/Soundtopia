package music.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lyric database table.
 * 
 */
@Entity
public class Lyric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

    @Lob()
	private String text;

	//bi-directional one-to-one association to Song
	@OneToOne
	@JoinColumn(name="id")
	private Song song;

    public Lyric() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
}