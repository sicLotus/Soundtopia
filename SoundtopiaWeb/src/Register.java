
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class Register implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(min = 3, message = "Email muss mindestens drei Zeichen besitzen")
	private String email;

	@Size(min = 3, message = "Passwort muss mindestens drei Zeichen besitzen")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
