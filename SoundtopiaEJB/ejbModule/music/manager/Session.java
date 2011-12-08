package music.manager;

import java.util.List;

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
import music.repository.SongDAO;
import music.services.AmazonAPI;
import music.services.GoogleImageAPI;
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

	public Session() {
	}

	public Song getSong(int id) {
		return em.find(Song.class, id);
	}

	public void readChartsFromMyvideo() {
		MyVideoAPI api = new MyVideoAPI();
		ChartEntryVO entry;
		List<ChartEntryVO> chartList = api.retrieveData();
		System.out.println("Succeeded: " + chartList.size());
	//	for (int i = 0; i < chartList.size(); i++) {
		//	entry = chartList.get(i);
		//	songDAO.createSong(entry.getInterpreter(), entry.getTitle(),
		//			entry.getMovie_length(), entry.getMovie_url());
			// addPicture(entry.getInterpreter(), entry.getTitle());
			// addLyric(entry.getInterpreter(), entry.getTitle());
			/*
			 new Charteintrag in ChartTabelle mit neuster ID (natürlich vor der for schleife)
			 ID an createChartEntry übergeben
			 die ganze methode soll dann 1x wöchentlich oder so ausgeführt werden
			 */
		//	Chart chart = chartDAO.createChartTable();
			//chartDAO.createChartEntry(chart.getId(), entry.getChartPlacing(), entry.getInterpreter(), entry.getTitle());
		//	chartDAO.test("Singlecharts");
		//	SevenDigitalsAPI.retrieveData(entry.getInterpreter()+ " "+entry.getTitle());
		SevenDigitalsAPI.retrieveData("LMFAO Party Rock Anthem");
	//}
		
		
		
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

}
