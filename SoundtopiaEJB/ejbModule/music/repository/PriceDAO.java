package music.repository;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import music.data.Price;
import music.data.PriceVO;

/**
 * Session Bean implementation class PriceDAO
 */
@Stateless
@LocalBean
public class PriceDAO {
	
	@EJB
	private SongDAO songDAO;

	@PersistenceContext
	private EntityManager em;

	public PriceDAO() {
	}

	public boolean doesPriceAndProviderExist(int songID, String provider) {
		if (findPriceBySongIDAndProvider(songID, provider) != null)
			return true;
		else
			return false;
	}

	public Price createPrice(int songID, PriceVO priceVO) {
		if (priceVO != null)
			if (!doesPriceAndProviderExist(songID, priceVO.getProvider())) {
				Price price = new Price();
				price.setSong(songDAO.findSong(songID));
				price.setOfferUrl(priceVO.getUrl());
				price.setValue(Float.valueOf(priceVO.getValue()));
				price.setProvider(priceVO.getProvider());
				price.setCurrency(priceVO.getCurrency());
				em.persist(price);
				return price;
			} else
				return updatePrice(songID, priceVO);
		else
			return null;
	}

	public Price updatePrice(int songID, PriceVO priceVO) {
		if (priceVO != null) {
			Price price = findPriceBySongIDAndProvider(songID,
					priceVO.getProvider());
			price.setCurrency(priceVO.getCurrency());
			price.setValue(priceVO.getValue());
			price.setOfferUrl(priceVO.getUrl());
			em.persist(price);
			return price;
		} else
			return null;
	}
	
	public void removeAllPrices(int songID) {
		List<Price> prices = findPriceBySongID(songID);
		for(Price p:prices) 
			em.remove(p);
		
	}

	public Price findPrice(int id) {
		return em.find(Price.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Price> findPriceBySongID(int songID) {
		List<Price> list = em.createNamedQuery("price.findBySongID")
				.setParameter("songID", songID).getResultList();
		return list;
	}

	public Price findPriceBySongIDAndProvider(int songID, String provider) {
		try {
			Price price = (Price) em.createNamedQuery("price.findBySongIDAndProvider").setParameter("songID", songID)
					.setParameter("provider", provider).getSingleResult();
			return price;
		} catch (NoResultException e) {
			return null;	
		}
	}
	
	
}
