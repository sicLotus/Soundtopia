package music.repository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import music.data.Lyric;
import music.data.User;

/**
 * Session Bean implementation class LyricDAO
 */
@Stateless
@LocalBean
public class LyricDAO {
	
	@PersistenceContext
	private EntityManager em;

    public LyricDAO() {
    }
    
	public Lyric createLyric() {
		Lyric lyric = new Lyric();
		//lyric.setEmail(email);
		//lyric.setPassword(password);
		
		em.persist(lyric);

		return lyric;
	}

}
