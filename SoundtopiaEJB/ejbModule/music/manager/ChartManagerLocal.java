package music.manager;
import java.util.List;

import javax.ejb.Local;

import music.data.SongVO;

@Local
public interface ChartManagerLocal {
	public List<SongVO> showCharts(String chartName, int start, int end, int userID);
	public int getMaxSongsInChart(String chartName);

}
