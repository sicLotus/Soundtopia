package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Price;
import music.data.User;

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
    
	public Price createPrice(String email, String password) {
		Price price = new Price();
		//price.setEmail(email);
		//price.setPassword(password);
		
		em.persist(price);

		return price;
	}

}
