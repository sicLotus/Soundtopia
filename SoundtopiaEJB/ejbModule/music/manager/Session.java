package music.manager;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Chart;
import music.data.ChartEntryVO;
import music.data.LyricVO;
import music.data.PriceVO;
import music.data.Song;
import music.repository.ChartDAO;
import music.repository.LyricDAO;
import music.repository.PriceDAO;
import music.repository.RatingDAO;
import music.repository.SongDAO;
import music.services.AmazonAPI;
import music.services.GoogleImageAPI;
import music.services.ItunesAPI;
import music.services.LyricAPI;
import music.services.MyVideoAPI;
import music.services.SevenDigitalsAPI;

/**
 * Session Bean implementation class session
 */
@Stateless
public class Session implements SessionRemote, SessionLocal {
	@PersistenceContext
	private EntityManager em;

	@EJB
	private SongDAO songDAO;

	@EJB
	private LyricDAO lyricDAO;

	@EJB
	private PriceDAO priceDAO;

	@EJB
	private ChartDAO chartDAO;

	@EJB
	private RatingDAO ratingDAO;

	public Session() {
	}

	public Song getSong(int id) {
		return em.find(Song.class, id);
	}

	/**
	 * Diese Methode sollte noch einen Timer (1x wöchentlich oder so bekommen!)
	 */
	public void readChartsFromMyvideo() {
		MyVideoAPI api = new MyVideoAPI();
		ChartEntryVO entry;
		List<ChartEntryVO> chartList = api.retrieveData();
		System.out.println("Succeeded: " + chartList.size());
		Chart chart = chartDAO.createChartTable();
		for (int i = 0; i < chartList.size(); i++) {
			entry = chartList.get(i);
			songDAO.createSong(entry.getInterpreter(), entry.getTitle(),
					entry.getMovie_length(), entry.getVideo());
			addPicture(entry.getInterpreter(), entry.getTitle());
			addLyric(entry.getInterpreter(), entry.getTitle());

			chartDAO.createChartEntry(chart.getId(), entry.getChartPlacing(),
					entry.getInterpreter(), entry.getTitle());
			// chartDAO.test("Singlecharts");
			addAmazonPrice(entry.getInterpreter(), entry.getTitle());
			addItunesPrice(entry.getInterpreter(), entry.getTitle());
			addSevenDigitalPrice(entry.getInterpreter(), entry.getTitle());
			// ItunesAPI.retrieveData(entry.getInterpreter() +" "+
			// entry.getTitle());
			//rateASong(1, entry.getInterpreter(), entry.getTitle(), 1);

		}

	}

	public void rateASong(int userID, String interpreter, String title,
			int rating) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null)
			rateASong(userID, song.getId(), rating);
	}

	public void rateASong(int userID, int songID, int rating) {
		Random rnd = new Random();
		int value = rnd.nextInt(5) + 1;
		ratingDAO.createRating(userID, songID, value);
	}

	public void addItunesPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = ItunesAPI.retrieveData(interpreter, title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addSevenDigitalPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = SevenDigitalsAPI.retrieveData(interpreter, title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addAmazonPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = AmazonAPI.retrieveData(
					AmazonAPI.SearchIndex.MP3Downloads, interpreter + " "
							+ title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addPicture(String interpreter, String title) {
		Song s = songDAO.findSong(interpreter, title);
		if (s != null) {
			String picture = GoogleImageAPI.retrieveData(interpreter, title);
			songDAO.addPicture(s.getId(), picture);
		}
	}

	public void addLyric(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			LyricVO lyric = LyricAPI.retrieveData(song.getInterpreter(),
					song.getTitle());
			lyricDAO.createLyric(song.getId(), lyric);
		}
	}

	public String getPictureFromGoogle(String interpreter, String title, int index) {
		return GoogleImageAPI.retrieveData(interpreter, title, index);
	}

	public String getPictureFromAmazon(String interpreter, String title) {
		return AmazonAPI.getPicture(interpreter, title);
	}

}
