package music.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Song;
import music.data.SongInChart;
import music.data.SongInChartPK;

/**
 * Session Bean implementation class SongDAO
 */
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
	
	public boolean doesChartEntryExist(SongInChartPK pk) {
		if (findChartEntry(pk) != null)
			return true;
		else
			return false;
	}

	public Song createSong(String interpreter, String title, int tracklength,
			String video) {
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
			return null;
	}
	
	public void createChartEntry(String interpreter, String title,
			int chartPlacing) {
		createChartEntry(interpreter, title, chartPlacing, 1);
	}
	
	public void createChartEntry(String interpreter, String title,
			int chartPlacing, int chartTable) {
		Song song = findSong(interpreter, title);
		SongInChartPK pk = new SongInChartPK();
		pk.setChartID(chartTable);
		pk.setSongID(song.getId());
		
		if(!doesChartEntryExist(pk)) {
		
		SongInChart sic = new SongInChart();		
		sic.setId(pk);
		sic.setAdded(new java.sql.Date(System.currentTimeMillis()));
		sic.setRanking(chartPlacing);

		em.persist(sic);
		}
	}

	public boolean addPicture(int songID, String picture) {
		try {
			Song song = getSong(songID);
			song.setPicture(picture);
			em.persist(song);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Song findSong(String interpreter, String title) {
		List<Song> list = em.createNamedQuery("song.findByInterpreterAndTitle")
				.setParameter("interpreter", interpreter)
				.setParameter("title", title).getResultList();
		if (list.size() > 0){
			System.out.println("Found:"+interpreter+" - "+title);
			return (Song) list.get(0);
		}
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public SongInChart findChartEntry(SongInChartPK pk) {
		
		List<SongInChart> list = em.createNamedQuery("songInChart.findByIds")
				.setParameter("id", pk).getResultList();
		if (list.size() > 0){
			return (SongInChart) list.get(0);
		}
		else
			return null;
	}

	public Song getSong(int id) {
		return em.find(Song.class, id);
	}

}
