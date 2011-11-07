package music.manager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class UserBO {
	
	@PersistenceUnit
	EntityManager em;
	//private List<User> users;
	//private UserDAO userHelper;
	
	public UserBO()	//public UserBO(UserDAO _userHelper)
	{
		//this.users = new ArrayList<User>();
		//this.userHelper = _userHelper;
	}
	
	//getter & setter
	
	//methods wie checkLogin, changePassword, halt alles was mit dem user zu tun hat
}
