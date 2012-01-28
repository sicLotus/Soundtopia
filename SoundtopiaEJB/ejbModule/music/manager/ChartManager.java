package music.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import music.data.SortType;
import music.data.DataObject.Chart;
import music.data.DataObject.Rating;
import music.data.DataObject.Song;
import music.data.DataObject.SongInChart;
import music.data.ValueObject.ChartEntryVO;
import music.data.ValueObject.LyricVO;
import music.data.ValueObject.PriceVO;
import music.data.ValueObject.SongVO;
import music.repository.ChartDAO;
import music.repository.LyricDAO;
import music.repository.PriceDAO;
import music.repository.RatingDAO;
import music.repository.SongDAO;
import music.services.AmazonAPI;
import music.services.GoogleImageAPI;
import music.services.ItunesAPI;
import music.services.LyricAPI;
import music.services.SevenDigitalsAPI;
import music.util.ListUtilities;

/**
 * Session Bean implementation class ChartManager
 */
@Stateless()
public class ChartManager implements ChartManagerRemote, ChartManagerLocal {
	public static final String SINGLECHARTS = "Singlecharts";
	@EJB
	private ChartDAO chartDAO;

	@EJB
	private SongDAO songDAO;

	@EJB
	private LyricDAO lyricDAO;

	@EJB
	private PriceDAO priceDAO;

	@EJB
	private RatingDAO ratingDAO;

	public ChartManager() {
	}

	public List<SongVO> showCharts(String chartName, int start, int end, int userID) {
		return showCharts(chartName, start, end, userID, SortType.RANKING);
	}

	public List<SongVO> showCharts(String chartName, int start, int end, int userID, SortType sort) {
		List<SongVO> chartList = new ArrayList<SongVO>();
		SongVO chartEntry;

		Chart chart = chartDAO.findChart(chartName);
		List<Song> songList = getSongList(start, end, userID, sort, chart);

		for (int i = 0; i < songList.size(); i++) {
			chartEntry = SongVO.valueOf(songList.get(i));
			if (sort.equals(SortType.RANKING))
				addRankingInformation(chartEntry, chart, songList.get(i).getSongInCharts());
			chartEntry.setUserRating(getUserRating(userID, songList.get(i).getId()));
			chartList.add(chartEntry);
		}
		return chartList;
	}

	private void addRankingInformation(SongVO chartEntry, Chart chart, Set<SongInChart> songs) {
		for (SongInChart sic : songs) {
			if (sic.getId().getChartID() == chart.getId()) {
				chartEntry.setRanking(sic.getRanking());
				chartEntry.setChange(sic.getChangeInRanking());
			}
		}
	}

	private int getUserRating(int userID, int songID) {
		if (isLoggedIn(userID)) {
			Rating rating = ratingDAO.findRating(userID, songID);
			if (rating != null)
				return rating.getRating();
			else
				return 0;
		} else
			return 0;
	}

	private boolean isLoggedIn(int userID) {
		return userID >= 0;
	}

	private List<Song> getSongList(int start, int end, int userID, SortType sort, Chart chart) {
		switch (sort) {
			case RATING :
				return songDAO.findTopUserCharts(chart.getId(), end);
			case VOTES :
				return songDAO.findTopUserChartsVotes(chart.getId(), end);
			case USERVOTES :
				return songDAO.findUserCharts(chart.getId(), userID, end);
			default :
				return songDAO.findSongInCharts(chart.getId(), start, end);
		}
	}

	public int getMaxSongsInChart(String chartName) {
		Chart chart = chartDAO.findChart(chartName);
		return chart.getSongInCharts().size();
	}

	/**
	 * @param search
	 *            Suchstring
	 * @param chartName
	 *            default immer Singlecharts
	 * @return Alle gefundenen Treffer mit '#' als Trennzeichen @
	 */
	public String suggestSearch(String[] search, String chartName) {
		StringBuffer sb = new StringBuffer();
		Chart chart = chartDAO.findChart(chartName); // hier könnte eine
														// exception
														// fliegen

		List<Song> resultList = getResultList(search, chart.getId());

		if (resultList != null)
			for (Song s : resultList) {
				sb.append(s.getChangedInterpreter() + " - " + s.getChangedTitle() + "#");
			}
		return sb.toString();
	}

	private List<Song> getResultList(String[] search, int chartID) {
		List<Song> oldResultList = songDAO.searchSongs(chartID, search[0]);
		List<Song> newResultList;
		for (int i = 1; i < search.length; i++) {
			newResultList = songDAO.searchSongs(chartID, search[i]);
			if (newResultList != null)
				oldResultList = ListUtilities.getEqualSongsInLists(oldResultList, newResultList);
		}
		return oldResultList;
	}

	public List<SongVO> searchSongs(int userID, String[] search, String chartName) {
		System.out.println("vor find chart");
		Chart chart = chartDAO.findChart(chartName);
		System.out.println("vor getresultlist");
		List<Song> resultList = getResultList(search, chart.getId());
		System.out.println("nach getResulstList");
		List<SongVO> results = new ArrayList<SongVO>();

		if (resultList != null) {
			SongVO chartEntry;
			for (Song s : resultList) {
				chartEntry = SongVO.valueOf(s);
				addRankingInformation(chartEntry, chart, s.getSongInCharts());
				chartEntry.setUserRating(getUserRating(userID, s.getId()));
				results.add(chartEntry);
			}
		}
		return results;
	}

	/*
	 * TODO Diese Methode sollte noch einen Timer (1x wöchentlich oder so
	 * bekommen!)
	 */
	@Schedule(dayOfWeek="Sun", hour="0") //- Sunday Midnight
	//@Schedule(minute="*/5", hour="*")
	public void readChartsFromMyVideoIntoDatabase() {
		/*ChartEntryVO entry;
		List<ChartEntryVO> chartList = MyVideoAPI.retrieveData();
		System.out.println("Succeeded: " + chartList.size());
		Chart chart = chartDAO.createSinglechartTable();
		for (int i = 0; i < chartList.size(); i++) {
			entry = chartList.get(i);
			addSong(entry);
			addPicture(entry.getInterpreter(), entry.getTitle());
			addLyric(entry.getInterpreter(), entry.getTitle());
			addChartEntry(entry, chart);
			addPrices(entry);
		}*/
		System.out.println("Schedule Test");
		
	}

	private void addChartEntry(ChartEntryVO entry, Chart chart) {
		chartDAO.createChartEntry(chart.getId(), entry.getChartPlacing(), entry.getInterpreter(), entry.getTitle());
	}

	private void addSong(ChartEntryVO entry) {
		songDAO.createSong(entry.getInterpreter(), entry.getTitle(), entry.getMovie_length(), entry.getVideo());
	}

	private void addPrices(ChartEntryVO entry) {
		addAmazonPrice(entry.getInterpreter(), entry.getTitle());
		addItunesPrice(entry.getInterpreter(), entry.getTitle());
		addSevenDigitalPrice(entry.getInterpreter(), entry.getTitle());
	}

	public void addItunesPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = ItunesAPI.getPrice(interpreter, title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addSevenDigitalPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = SevenDigitalsAPI.getPrice(interpreter, title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addAmazonPrice(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			PriceVO item = AmazonAPI.getPrice(AmazonAPI.SearchIndex.MP3Downloads, interpreter, title);
			priceDAO.createPrice(song.getId(), item);
		}
	}

	public void addPicture(String interpreter, String title) {
		Song s = songDAO.findSong(interpreter, title);
		if (s != null) {
			String picture = GoogleImageAPI.retrieveData(interpreter, title);
			songDAO.addCover(s.getId(), picture);
		}
	}

	public void addLyric(String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		if (song != null) {
			LyricVO lyric = LyricAPI.retrieveData(song.getInterpreter(), song.getTitle());
			lyricDAO.createLyric(song.getId(), lyric);
		}
	}

}