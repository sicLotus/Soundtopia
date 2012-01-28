package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.DataObject.SongAddition;

@Stateless
@LocalBean
public class SongAdditionDAO {

	@PersistenceContext
	private EntityManager em;

	public SongAdditionDAO() {
	}

	public boolean doesSongAdditionExists(int songID) {
		if (findSongAddition(songID) != null)
			return true;
		else
			return false;
	}

	public SongAddition createSongAddition(int songID, String interpreter, String title, String cover) {
		if (!doesSongAdditionExists(songID)) {
			SongAddition songAddition = new SongAddition();
			songAddition.setSongID(songID);
			if (!interpreter.equals(""))
				songAddition.setInterpreter(interpreter);
			if (!title.equals(""))
				songAddition.setTitle(title);
			if (!cover.equals(""))
				songAddition.setCover(cover);
			em.persist(songAddition);
			return songAddition;
		} else
			return updateSongAddition(songID, interpreter, title, cover);
	}

	public SongAddition updateSongAddition(int songID, String interpreter, String title, String cover) {
		SongAddition s = findSongAddition(songID);
		if (!interpreter.equals(""))
			s.setInterpreter(interpreter);
		if (!title.equals(""))
			s.setTitle(title);
		if (!cover.equals(""))
			s.setCover(cover);
		em.persist(s);
		return s;
	}

	public void deleteSongAddition(int songID) {
		SongAddition sa = findSongAddition(songID);
		if (sa != null)
			em.remove(sa);
	}

	public SongAddition findSongAddition(int songID) {
		return em.find(SongAddition.class, songID);
	}

}
