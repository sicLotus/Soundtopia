package music.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.DataObject.Song;

@Stateless
@LocalBean
public class SongDAO {

	@PersistenceContext
	private EntityManager em;

	public SongDAO() {
	}

	public boolean doesSongExist(String interpreter, String title) {
		if (findSong(interpreter, title) != null)
			return true;
		else
			return false;
	}

	public Song createSong(String interpreter, String title, int tracklength, String video) {
		if (!doesSongExist(interpreter, title)) {
			Song song = new Song();
			song.setDate(new java.sql.Date(System.currentTimeMillis()));
			song.setInterpreter(interpreter);
			song.setTitle(title);
			song.setTracklength(tracklength);
			song.setVideo(video);
			song.setRating(0f);
			song.setVoteCount(0);
			song.setVoteTotal(0);
			em.persist(song);
			return song;
		} else
			return updateSong(interpreter, title, tracklength, video);
	}

	public Song updateSong(String interpreter, String title, int tracklength, String video) {
		Song song = findSong(interpreter, title);
		song.setInterpreter(interpreter);
		song.setTitle(title);
		song.setTracklength(tracklength);
		song.setVideo(video);
		em.persist(song);
		return song;
	}

	public boolean addCover(int songID, String cover) {
		try {
			Song song = findSong(songID);
			song.setCover(cover);
			em.persist(song);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Song findSong(String interpreter, String title) {
		List<Song> list = em.createNamedQuery("song.findByInterpreterAndTitle").setParameter("interpreter", interpreter).setParameter("title", title).getResultList();
		if (list.size() > 0) {
			return (Song) list.get(0);
		} else
			return null;
	}

	public Song findSong(int id) {
		return em.find(Song.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Song> findSongInCharts(int chartID, int start, int end) {
		List<Song> list = em.createNamedQuery("song.findSongsInChart").setParameter("chartID", chartID).setParameter("start", start).setParameter("end", end).getResultList();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Song> findTopUserCharts(int chartID, int end) {
		List<Song> list = em.createNamedQuery("song.findTopUserCharts").setParameter("chartID", chartID).setMaxResults(end).getResultList();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Song> findTopUserChartsVotes(int chartID, int end) {
		List<Song> list = em.createNamedQuery("song.findTopUserChartsVotes").setParameter("chartID", chartID).setMaxResults(end).getResultList();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Song> findUserCharts(int chartID, int userID, int end) {
		List<Song> list = em.createNamedQuery("song.findUserCharts").setParameter("chartID", chartID).setParameter("userID", userID).setMaxResults(end).getResultList();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Song> searchSongs(int chartID, String search) {
		List<Song> list = em.createNamedQuery("song.findSearchResults").setParameter("chartID", chartID).setParameter("search", "%" + search + "%").getResultList();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}
}
