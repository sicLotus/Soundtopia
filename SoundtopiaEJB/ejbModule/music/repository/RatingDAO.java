package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Rating;
import music.data.RatingPK;

@Stateless
@LocalBean
public class RatingDAO {

	@PersistenceContext
	private EntityManager em;

	public RatingDAO() {
	}

	public boolean doesRatingExist(RatingPK pk) {
		if (findRating(pk) != null)
			return true;
		else
			return false;
	}

	public void createRating(int userID, int songID, int ratingValue) {
		RatingPK pk = new RatingPK();
		pk.setSongID(songID);
		pk.setUserID(userID);

		if (!doesRatingExist(pk)) {

			Rating rating = new Rating();
			rating.setId(pk);
			rating.setRating(ratingValue);
			em.persist(rating);
		} else
			updateRating(pk, ratingValue);
	}

	public void updateRating(RatingPK pk, int ratingValue) {
		Rating rating = findRating(pk);
		rating.setRating(ratingValue);
		em.persist(rating);
	}

	public void updateRating(int userID, int songID, int ratingValue) {
		Rating rating = findRating(userID, songID);
		rating.setRating(ratingValue);
		em.persist(rating);
	}

	public void deleteRating(int userID, int songID) {
		RatingPK pk = new RatingPK();
		pk.setSongID(songID);
		pk.setUserID(userID);
		if (doesRatingExist(pk)) {
			Rating rating = findRating(pk);
			em.remove(rating);
		}
	}

	public Rating findRating(int uid, int sid) {
		RatingPK pk = new RatingPK();
		pk.setSongID(sid);
		pk.setUserID(uid);
		return em.find(Rating.class, pk);
	}

	public Rating findRating(RatingPK pk) {
		return em.find(Rating.class, pk);
	}

}
