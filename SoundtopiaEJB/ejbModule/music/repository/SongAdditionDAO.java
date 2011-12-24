package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.SongAddition;

/**
 * Session Bean implementation class SongAdditionDAO
 */
@Stateless
@LocalBean
public class SongAdditionDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SongAdditionDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean doesSongAdditionExists(int songID) {
		if (findSongAddition(songID) != null)
			return true;
		else
			return false;
	}

	public void createSongAddition(int songID, String interpreter,
			String title, String cover) {
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
		} else
			updateSongAddition(songID, interpreter, title, cover);
	}

	public void updateSongAddition(int songID, String interpreter,
			String title, String cover) {
		SongAddition s = findSongAddition(songID);
		if (!interpreter.equals(""))
			s.setInterpreter(interpreter);

		if (!title.equals(""))
			s.setTitle(title);

		if (!cover.equals(""))
			s.setCover(cover);

		em.persist(s);
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
