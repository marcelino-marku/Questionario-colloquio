package questionario.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Admin {
	

	@NotNull 
	@Pattern(regexp = "^\\S+@\\S+$", message = "email non valida")
	private String email;
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "password non valida")
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
