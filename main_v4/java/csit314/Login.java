
package csit314;

import java.io.Serializable;

public class Login implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String fullname;
	private String username;
	private String password;
	private String role;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
