package co.edu.udistrital.web.dto;


public class UserWebDTO {
	
		

	private String username;
	
	private String password;

	private boolean enable;
	
	private String rolename;
	
	private boolean esCrear;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEsCrear() {
		return esCrear;
	}

	public void setEsCrear(boolean esCrear) {
		this.esCrear = esCrear;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password
				+ ", enable=" + enable + ", rolename=" + rolename
				+ ", esCrear=" + esCrear + "]";
	}

	
}
