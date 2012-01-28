package music.data.DataObject;

import java.io.Serializable;
import javax.persistence.*;

import music.data.ISong;

/**
 * The persistent class for the song_addition database table.
 * 
 */
@Entity
@Table(name = "song_addition")
public class SongAddition implements Serializable, ISong {
	private static final long serialVersionUID = 1L;

	@Id
	private int songID;

	// bi-directional one-to-one association to Song
	@OneToOne(mappedBy = "songAddition")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see music.data.ISong#getCover()
	 */
	@Override
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see music.data.ISong#getInterpreter()
	 */
	@Override
	public String getInterpreter() {
		return this.interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see music.data.ISong#getTitle()
	 */
	@Override
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