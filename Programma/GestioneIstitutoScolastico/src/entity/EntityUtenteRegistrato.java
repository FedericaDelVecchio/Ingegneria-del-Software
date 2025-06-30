package entity;

public abstract class EntityUtenteRegistrato {
	protected String username;
	protected String password;
	
	public EntityUtenteRegistrato() {
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

	@Override
	public String toString() {
		return "EntityUtenteRegistrato [username=" + username + ", password=" + password + "]";
	}
	
	
}
