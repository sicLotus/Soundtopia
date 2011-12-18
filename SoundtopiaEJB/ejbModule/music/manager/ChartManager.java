package music.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.Chart;
import music.data.ChartEntryVO;
import music.data.Lyric;
import music.data.LyricVO;
import music.data.Price;
import music.data.PriceVO;
import music.data.Song;
import music.data.SongVO;
import music.repository.ChartDAO;
import music.repository.LyricDAO;
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

	public ChartManager() {
	}

	public List<SongVO> showCharts(String chartName, int start, int end) {
		List<SongVO> chartList = new ArrayList<SongVO>();
		LyricVO lyricVO;
		Lyric lyric;
		PriceVO priceVO;
		List<PriceVO> pricesVO;
		Set<Price> prices;
		SongVO chartEntry;
		System.out.println("vor query");
		Chart chart = chartDAO.findChart(chartName);
		System.out.println("Chart: " + chart);
		List<Song> songList = songDAO.findSongInCharts(chart.getId(), start, end);
		System.out.println("SongList: " + songList);
		for (int i = 0; i < songList.size(); i++) {
			chartEntry = new SongVO();
			chartEntry.setInterpreter(songList.get(i).getInterpreter());
			chartEntry.setRanking(i + start);
			chartEntry.setTitle(songList.get(i).getTitle());
			chartEntry.setTracklength(songList.get(i).getTracklength());
			chartEntry.setVideo(songList.get(i).getVideo());
			chartEntry.setPicture(songList.get(i).getPicture());
			chartEntry.setRating(songList.get(i).getRating());

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

}
