package music.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import music.data.User;
import music.repository.UserDAO;

@Stateless
public class UserBO implements UserBOLocal, UserBORemote {
		
	private List<User> users;
	
	@EJB
	private UserDAO userHelper;
	
	public UserBO()
	{
		this.users = new ArrayList<User>();
	}
	
	public boolean createUser(String name, String email, String password) {
		return false;
	}
	
	public boolean checkLogin() {
		return false;
	}
	
	public boolean changePassword() {
		return false;
	}
	
	public User getUser(String username){
		User u = new User();
		u = userHelper.findByName(username);
		return u;	
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	//getter & setter
	
	//methods wie checkLogin, changePassword, halt alles was mit dem user zu tun hat
}
