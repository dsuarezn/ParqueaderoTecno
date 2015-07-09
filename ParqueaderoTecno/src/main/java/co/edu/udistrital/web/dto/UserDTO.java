package co.edu.udistrital.web.dto;


public class UserDTO {

	private String username;
	
	private String password;

	private Boolean enable;
	
	private String rolename;
	
	private Boolean esCrear;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
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

	public Boolean getEsCrear() {
		return esCrear;
	}

	public void setEsCrear(Boolean esCrear) {
		this.esCrear = esCrear;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password
				+ ", enable=" + enable + ", rolename=" + rolename
				+ ", esCrear=" + esCrear + "]";
	}

	
}
