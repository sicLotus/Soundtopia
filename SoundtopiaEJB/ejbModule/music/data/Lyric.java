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
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int songID;

    @Lob()
	private String text;

	private String url;

	//bi-directional one-to-one association to Song
	@OneToOne(mappedBy="lyric")
	private Song song;

    public Lyric() {
    }

	public int getSongID() {
		return this.songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
}