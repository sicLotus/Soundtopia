package music.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.Chart;
import music.data.Lyric;
import music.data.LyricVO;
import music.data.Price;
import music.data.PriceVO;
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

	public List<SongVO> showCharts(String chartName, int start, int end, int userID) {
		List<SongVO> chartList = new ArrayList<SongVO>();
		LyricVO lyricVO;
		Lyric lyric;
		PriceVO priceVO;
		List<PriceVO> pricesVO;
		Set<Price> prices;
		SongVO chartEntry;
		Rating rating;
		Chart chart = chartDAO.findChart(chartName);
		List<Song> songList = songDAO.findSongInCharts(chart.getId(), start,
				end);
		for (int i = 0; i < songList.size(); i++) {
			chartEntry = new SongVO();
			chartEntry.setId(songList.get(i).getId());
			chartEntry.setInterpreter(songList.get(i).getInterpreter());
			for (SongInChart sic : songList.get(i).getSongInCharts()) {
				if (sic.getId().getChartID() == chart.getId()) {
					chartEntry.setRanking(sic.getRanking());
					chartEntry.setChange(sic.getChangeInRanking());
				}
			}
			chartEntry.setTitle(songList.get(i).getTitle());
			chartEntry.setTracklength(convertToTime(songList.get(i).getTracklength()));
			chartEntry.setVideo(songList.get(i).getVideo());
			chartEntry.setPicture(songList.get(i).getPicture());
			
			chartEntry.setRating(songList.get(i).getRating());
			
			if (userID >= 0) {
				rating = ratingDAO.findRating(userID, songList.get(i).getId());
				if (rating != null)
					chartEntry.setUserRating(rating.getRating());
				else chartEntry.setUserRating(0);
			} else chartEntry.setUserRating(0);

			lyric = songList.get(i).getLyric();
			if (lyric != null) {
				lyricVO = new LyricVO();
				lyricVO.setText(lyric.getText());
				lyricVO.setUrl(lyric.getUrl());
				chartEntry.setLyric(lyricVO);
			}

			prices = songList.get(i).getPrices();
			if (prices != null) {
				pricesVO = new ArrayList<PriceVO>();
				for (Price p : prices) {
					priceVO = new PriceVO();
					priceVO.setCurrency(p.getCurrency());
					priceVO.setProvider(p.getProvider());
					priceVO.setUrl(p.getOfferUrl());
					priceVO.setValue(p.getValue());
					pricesVO.add(priceVO);
				}
				chartEntry.setPrices(pricesVO);
			}
			chartList.add(chartEntry);
		}
		return chartList;
	}
	
	private String convertToTime(int sec) {
		String result;
		int minutes = sec / 60;
		int seconds = sec % 60;
		if (seconds < 10)
			result = minutes+":0"+seconds;
		else result = minutes+":"+seconds;
		return result;
	}

}
