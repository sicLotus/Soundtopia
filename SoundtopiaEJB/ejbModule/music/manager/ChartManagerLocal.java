package music.manager;

import java.util.List;

import javax.ejb.Local;

import music.data.SortType;
import music.data.ValueObject.SongVO;

@Local
public interface ChartManagerLocal {
	public int getMaxSongsInChart(String chartName);
	public void readChartsFromMyVideoIntoDatabase();
	public String suggestSearch(String[] search, String chartName);
	public List<SongVO> searchSongs(int userID, String[] search, String chartName);
	public List<SongVO> showCharts(String chartName, int start, int end, int userID, SortType rating);
	public List<SongVO> showCharts(String chartName, int start, int end, int userID);
}
