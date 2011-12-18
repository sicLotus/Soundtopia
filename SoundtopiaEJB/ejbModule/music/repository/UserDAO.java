package music.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO {

	@PersistenceContext
	private EntityManager em;

	public UserDAO() {
	}
	
	public User createUser(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		em.persist(user);

		return user;
	}

	public User getUser(int id) {
		return em.find(User.class, id);
	}

	public User findByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<User> list = em.createNamedQuery("user.findByEmail")
				.setParameter("email", email).getResultList();
		
		if (list != null && list.size() > 0)
			return (User) list.get(0);
		else
			return null;
	}

	public void setPassword(String email, String sha1) {
		User u = findByEmail(email);
		
		if (u != null) {
			u.setPassword(sha1);
			em.persist(u);
		}
	}

}
