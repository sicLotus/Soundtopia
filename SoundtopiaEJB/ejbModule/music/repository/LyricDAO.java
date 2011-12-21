package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Lyric;
import music.data.LyricVO;

/**
 * Session Bean implementation class LyricDAO
 */
@Stateless
@LocalBean
public class LyricDAO {

	@PersistenceContext
	private EntityManager em;


	public LyricDAO() {
	}

	public boolean doesLyricExist(int songID) {
		if (findLyric(songID) != null)
			return true;
		else
			return false;
	}

	public Lyric createLyric(int songID, LyricVO lyricVO) {
		if (!doesLyricExist(songID)) {
			Lyric lyric = new Lyric();
			lyric.setSongID(songID);
			lyric.setText(lyricVO.getText());
			lyric.setUrl(lyricVO.getUrl());
			em.persist(lyric);
			return lyric;
		} else
			return null;
	}

	public Lyric updateLyric(int songID, LyricVO lyricVO) {
		if (lyricVO != null) {
			Lyric lyric = findLyric(songID);
			if (lyric != null) {
				lyric.setText(lyricVO.getText());
				lyric.setUrl(lyricVO.getUrl());
				em.persist(lyric);
				return lyric;
			}
		}
		return null;
	}
	
	public Lyric findLyric(int songID) {
		return em.find(Lyric.class, songID);
	}
}
