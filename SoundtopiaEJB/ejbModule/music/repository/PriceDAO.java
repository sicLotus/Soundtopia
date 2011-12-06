package music.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Price;
import music.data.PriceVO;

/**
 * Session Bean implementation class PriceDAO
 */
@Stateless
@LocalBean
public class PriceDAO {
	
	@PersistenceContext
	private EntityManager em;

    public PriceDAO() {
    }
    

	
	public boolean doesPriceAndProviderExist(int songID, String provider) {
		if (findPriceBySongIDAndProvicer(songID, provider).size() > 0)
			return true;
		else
			return false;
	}

	public Price createPrice(int songID, PriceVO priceVO) {
		if (!doesPriceAndProviderExist(songID, priceVO.getProvider())) {
			Price price = new Price();
			price.setId(songID);
			price.setOfferUrl(priceVO.getUrl());
			price.setValue(Float.valueOf(priceVO.getValue()));
			price.setProvider(priceVO.getProvider());
			em.persist(price);
			return price;
		} else
			return null;
	}

	public Price getPrice(int id) {
		return em.find(Price.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Price> findPriceBySongID(int songID) {
		List<Price> list = em.createNamedQuery("price.findBySongID")
				.setParameter("songID", songID).getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Price> findPriceBySongIDAndProvicer(int songID, String provider) {
		List<Price> list = em.createNamedQuery("price.findBySongIDAndProvider")
				.setParameter("songID", songID).setParameter("provider", provider).getResultList();
		return list;
	}
		

}
