package music.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.DataObject.User;

@Stateless
@LocalBean
public class UserDAO {

	@PersistenceContext
	private EntityManager em;

	public UserDAO() {
	}

	private boolean doesUserExist(String email) {
		if (findByEmail(email) != null)
			return true;
		else
			return false;
	}

	public User createUser(String email, String password, byte admin) {
		if (doesUserExist(email))
			return null;
		else {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setAdmin(admin);
			em.persist(user);
			return user;
		}
	}

	public User getUser(int id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		List<User> list = em.createNamedQuery("user.findByEmail").setParameter("email", email).getResultList();
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
