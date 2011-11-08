package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import music.data.User;

@Stateless
@LocalBean
public class UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public User findByName(String name) {
		return (User) em.createQuery("select u from User u where u.name='" + name + "'").getResultList().get(0);
	}
	
	public User getUser(int id) {
		return em.find(User.class, id);
	}

}
