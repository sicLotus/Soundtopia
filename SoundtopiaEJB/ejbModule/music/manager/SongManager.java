package music.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.ISong;
import music.data.DataObject.Song;
import music.data.DataObject.SongAddition;
import music.data.ValueObject.LyricVO;
import music.data.ValueObject.SongAdditionVO;
import music.data.ValueObject.SongVO;
import music.repository.LyricDAO;
import music.repository.PriceDAO;
import music.repository.RatingDAO;
import music.repository.SongAdditionDAO;
import music.repository.SongDAO;
import music.services.AmazonAPI;
import music.services.GoogleImageAPI;
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

	public SongAdditionVO getSongInformation(int songID) {
		SongAdditionVO songAdditionVO = new SongAdditionVO();
		ISong song = songAdditionDAO.findSongAddition(songID);
		if (song == null) {
			song = songDAO.findSong(songID);
		}
		if (song != null) {
			setSongAttributes(songAdditionVO, song);
		}

		return songAdditionVO;
	}

	private void setSongAttributes(SongAdditionVO songAdditionVO, ISong iSong) {
		songAdditionVO.setCover(iSong.getCover());
		songAdditionVO.setTitle(iSong.getTitle());
		songAdditionVO.setInterpreter(iSong.getInterpreter());
	}

	public SongVO changeSongInformation(int songID, SongVO songVO) {
		Song song = songDAO.findSong(songID);
		SongAddition sa = songAdditionDAO.createSongAddition(songID, songVO.getInterpreter(), songVO.getTitle(), songVO.getCover());

		if (!hasChangedInterpreterOrTitle(song, sa))
			readNewSongInformationFromAPIs(songID, songVO.getInterpreter(), songVO.getTitle());

		song = songDAO.findSong(songID);
		return SongVO.valueOf(song);
	}

	private boolean hasChangedInterpreterOrTitle(Song song, SongAddition sa) {
		return song.getInterpreter().equals(sa.getInterpreter()) && song.getTitle().equals(sa.getTitle());
	}

	public void readNewSongInformationFromAPIs(int songID, String interpreter, String title) {
		System.out.println("read new informations");
		LyricVO lyric = LyricAPI.retrieveData(interpreter, title);
		lyricDAO.createLyric(songID, lyric);

		priceDAO.removeAllPrices(songID);
		priceDAO.createPrice(songID, AmazonAPI.getPrice(AmazonAPI.SearchIndex.MP3Downloads, interpreter, title));
		priceDAO.createPrice(songID, ItunesAPI.getPrice(interpreter, title));
		priceDAO.createPrice(songID, SevenDigitalsAPI.getPrice(interpreter, title));
	}

	public SongVO undoChanges(int songID) {
		SongVO songVO = new SongVO();
		songAdditionDAO.deleteSongAddition(songID);
		songVO = getSong(songID);
		return songVO;
	}

	public SongVO getSong(int songID) {
		Song song = songDAO.findSong(songID);
		return SongVO.valueOf(song);
	}

	public float getMeanRate(int songID) {
		Song song = songDAO.findSong(songID);
		return song.getRating();
	}

	public int getVoteCount(int songID) {
		Song song = songDAO.findSong(songID);
		return song.getVoteCount();
	}

	public String getPictureFromGoogle(String interpreter, String title, int index) {
		return GoogleImageAPI.retrieveData(interpreter, title, index);
	}

	public String getPictureFromAmazon(String interpreter, String title) {
		return AmazonAPI.getCover(interpreter, title);
	}
}
