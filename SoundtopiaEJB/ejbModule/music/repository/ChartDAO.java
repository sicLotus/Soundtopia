package music.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Chart;
import music.data.Song;
import music.data.SongInChart;
import music.data.SongInChartPK;

/**
 * Session Bean implementation class ChartDAO
 */
@Stateless
@LocalBean
public class ChartDAO {
	@PersistenceContext
	private EntityManager em;

	@EJB
	private SongDAO songDAO;

	public ChartDAO() {
	}

	public boolean doesChartEntryExist(SongInChartPK pk) {
		if (findChartEntry(pk) != null)
			return true;
		else
			return false;
	}

	public Chart createChartTable() {
		return createChartTable("Singlecharts");
	}

	public Chart createChartTable(String name) {
		Chart chart = new Chart();
		chart.setName(name);
		chart.setLastUpdated(new java.sql.Date(System.currentTimeMillis()));
		em.persist(chart);
		return chart;
	}

	public void createChartEntry(int chartTable, int chartPlacing,
			String interpreter, String title) {
		Song song = songDAO.findSong(interpreter, title);
		SongInChartPK pk = new SongInChartPK();
		pk.setChartID(chartTable);
		pk.setSongID(song.getId());

		if (!doesChartEntryExist(pk)) {

			SongInChart sic = new SongInChart();
			sic.setId(pk);
			sic.setRanking(chartPlacing);

			em.persist(sic);
		}
	}

	@SuppressWarnings("unchecked")
	public Chart findChart(String name) {
		List<Chart> list = em.createNamedQuery("chart.findChart")
				.setParameter("name", name).getResultList();
		if (list.size() > 0) {
			return (Chart) list.get(0);
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public SongInChart findChartEntry(SongInChartPK pk) {
		List<SongInChart> list = em.createNamedQuery("songInChart.findByIds")
				.setParameter("id", pk).getResultList();
		if (list.size() > 0) {
			return (SongInChart) list.get(0);
		} else
			return null;
	}
	

}
