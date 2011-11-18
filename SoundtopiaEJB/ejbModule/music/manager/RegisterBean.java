package music.manager;
import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import music.data.Register;


@Named
@RequestScoped
public class RegisterBean implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Inject
	private Register register;
	
	public String registerAccount() {
		System.out.println("register new account...");
		
		//create new user here
		System.out.println("email="+register.getEmail());
		return "/registerSuccess.xhtml";
	}
}
