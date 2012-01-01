package music.manager;
import java.util.List;

import javax.ejb.Remote;

import music.data.SongVO;
import music.data.SortType;

@Remote
public interface ChartManagerRemote {
	public List<SongVO> showCharts(String chartName, int start, int end,
			int userID);

	public int getMaxSongsInChart(String chartName);

	public String suggestSearch(String[] search, String chartName);

	public List<SongVO> searchSongs(int userID, String[] search,
			String chartName);

	public List<SongVO> showCharts(String chartName, int start, int end,
			int userID, SortType rating);
}
