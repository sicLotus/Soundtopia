package music.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.LyricVO;
import music.data.Song;
import music.data.SongAddition;
import music.data.SongAdditionVO;
import music.data.SongVO;
import music.repository.LyricDAO;
import music.repository.PriceDAO;
import music.repository.RatingDAO;
import music.repository.SongAdditionDAO;
import music.repository.SongDAO;
import music.services.AmazonAPI;
import music.services.ItunesAPI;
import music.services.LyricAPI;
import music.services.SevenDigitalsAPI;

/**
 * Session Bean implementation class SongManager
 */
@Stateless
public class SongManager implements SongManagerRemote, SongManagerLocal {

	@EJB
	private RatingDAO ratingDAO;

	@EJB
	private SongDAO songDAO;

	@EJB
	private SongAdditionDAO songAdditionDAO;

	@EJB
	private LyricDAO lyricDAO;

	@EJB
	private PriceDAO priceDAO;

	public SongManager() {
	}

	/**
	 * 
	 * @return Durchschnittsbewertung eines Songs geht nicht, da der trigger
	 *         scheinbar zu langsam ist oO
	 */
	public void rateASong(int userID, int songID, int rating) {
		ratingDAO.createRating(userID, songID, rating);
		// Song song = songDAO.findSong(songID);
		// return song.getRating();
	}

	public float getMeanRate(int songID) {
		Song song = songDAO.findSong(songID);
		return song.getRating();
	}

	public SongAdditionVO getSongInformation(int songID) {
		SongAdditionVO songAdditionVO = new SongAdditionVO();
		SongAddition songAddition = songAdditionDAO.findSongAddition(songID);

		if (songAddition != null) {
			songAdditionVO.setCover(songAddition.getCover());
			songAdditionVO.setTitle(songAddition.getTitle());
			songAdditionVO.setInterpreter(songAddition.getInterpreter());
		} else {
			Song song = songDAO.findSong(songID);
			if (song != null) {
				songAdditionVO.setCover(song.getPicture());
				songAdditionVO.setTitle(song.getTitle());
				songAdditionVO.setInterpreter(song.getInterpreter());
			}
		}
		return songAdditionVO;
	}

	public SongVO changeSongInformation(int songID, String interpreter,
			String title, String cover) {
		Song song = songDAO.findSong(songID);
		SongAddition sa = songAdditionDAO.createSongAddition(songID,
				interpreter, title, cover);

		if (!(song.getInterpreter().equals(sa.getInterpreter()) && song
				.getTitle().equals(sa.getTitle())))
			readNewSongInformationFromAPIs(songID, interpreter, title);

		song = songDAO.findSong(songID);
		SongVO songVO = new SongVO();
		songVO.valueOf(song);

		return songVO;
	}

	public void readNewSongInformationFromAPIs(int songID, String interpreter,
			String title) {
		System.out.println("red new informations");
		LyricVO lyric = LyricAPI.retrieveData(interpreter, title);
		lyricDAO.createLyric(songID, lyric);

		priceDAO.removeAllPrices(songID);
		priceDAO.createPrice(songID, AmazonAPI.retrieveData(
				AmazonAPI.SearchIndex.MP3Downloads, interpreter + " " + title));
		priceDAO.createPrice(songID, ItunesAPI.retrieveData(interpreter, title));
		priceDAO.createPrice(songID,
				SevenDigitalsAPI.retrieveData(interpreter, title));
	}

	public SongVO undoChanges(int songID) {
		SongVO songVO = new SongVO();

		songAdditionDAO.deleteSongAddition(songID);
		songVO = getSong(songID);
		return songVO;
	}

	public SongVO getSong(int songID) {
		Song song = songDAO.findSong(songID);
		SongVO songVO = new SongVO();
		songVO.valueOf(song);
		return songVO;
	}

}
