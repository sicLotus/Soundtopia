package music.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.Chart;
import music.data.Rating;
import music.data.Song;
import music.data.SongInChart;
import music.data.SongVO;
import music.repository.ChartDAO;
import music.repository.RatingDAO;
import music.repository.SongDAO;

/**
 * Session Bean implementation class ChartManager
 */
@Stateless
public class ChartManager implements ChartManagerRemote, ChartManagerLocal {

	@EJB
	private ChartDAO chartDAO;

	@EJB
	private SongDAO songDAO;

	@EJB
	private RatingDAO ratingDAO;

	public ChartManager() {
	}

	public List<SongVO> showCharts(String chartName, int start, int end,
			int userID) {
		List<SongVO> chartList = new ArrayList<SongVO>();
		SongVO chartEntry;
		Rating rating;
		Chart chart = chartDAO.findChart(chartName);
		List<Song> songList = songDAO.findSongInCharts(chart.getId(), start,
				end);
		for (int i = 0; i < songList.size(); i++) {
			chartEntry = new SongVO();

			chartEntry.valueOf(songList.get(i));

			for (SongInChart sic : songList.get(i).getSongInCharts()) {
				if (sic.getId().getChartID() == chart.getId()) {
					chartEntry.setRanking(sic.getRanking());
					chartEntry.setChange(sic.getChangeInRanking());
				}
			}

			if (userID >= 0) {
				rating = ratingDAO.findRating(userID, songList.get(i).getId());
				if (rating != null)
					chartEntry.setUserRating(rating.getRating());
				else
					chartEntry.setUserRating(0);
			} else
				chartEntry.setUserRating(0);

			chartList.add(chartEntry);
		}
		return chartList;
	}

	public int getMaxSongsInChart(String chartName) {
		Chart chart = chartDAO.findChart(chartName);
		return chart.getSongInCharts().size();

	}

	private List<Song> compareLists(List<Song> a, List<Song> b) {
		List<Song> result = new ArrayList<Song>();
		for (Song sa : a) {
			for (Song sb : b) {
				if (sa.getInterpreter().equals(sb.getInterpreter())
						&& sa.getTitle().equals(sb.getTitle())) {
					result.add(sa);
					continue;
				}
			}
		}
		return result;
	}

	/**
	 * @param search
	 *            Suchstring
	 * @param chartName
	 *            default immer Singlecharts
	 * @return Alle gefundenen Treffer mit '#' als Trennzeichen
	 */
	public String suggestSearch(String[] search, String chartName) {
		StringBuffer sb = new StringBuffer();
		int chartID = chartDAO.findChart(chartName).getId(); // hier könnte eine
																// exception
																// fliegen

		List<Song> oldResultList = songDAO.searchSongs(chartID, search[0]);
		List<Song> newResultList;
		for (int i = 1; i < search.length; i++) {
			newResultList = songDAO.searchSongs(chartID, search[i]);
			if (newResultList != null)
				oldResultList = compareLists(oldResultList, newResultList);
		}

		if (oldResultList != null)
			for (Song s : oldResultList) {
				sb.append(s.getChangedInterpreter() + " - "
						+ s.getChangedTitle() + "#");
			}
		return sb.toString();
	}

	public List<SongVO> searchSongs(int userID, String[] search, String chartName) {
		int chartID = chartDAO.findChart(chartName).getId();
		List<Song> oldResultList = songDAO.searchSongs(chartID, search[0]);
		List<Song> newResultList;
		List<SongVO> results = new ArrayList<SongVO>();
		for (int i = 1; i < search.length; i++) {
			newResultList = songDAO.searchSongs(chartID, search[i]);
			if (newResultList != null)
				oldResultList = compareLists(oldResultList, newResultList);
		}

		if (oldResultList != null) {
			SongVO chartEntry;
			Rating rating;
			for (Song s : oldResultList) {		
				chartEntry = new SongVO();

				chartEntry.valueOf(s);

				for (SongInChart sic : s.getSongInCharts()) {
					if (sic.getId().getChartID() == chartID) {
						chartEntry.setRanking(sic.getRanking());
						chartEntry.setChange(sic.getChangeInRanking());
					}
				}

				if (userID >= 0) {
					rating = ratingDAO.findRating(userID, s.getId());
					if (rating != null)
						chartEntry.setUserRating(rating.getRating());
					else
						chartEntry.setUserRating(0);
				} else
					chartEntry.setUserRating(0);
				
				results.add(chartEntry);
			}
		}
		return results;
	}

}