package org.escalade.model;

public class User {
	private int id;
	private String login;
	private String pswd;
	private Role role;
	
	// GETTERS SETTERS //
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String pLogin) {
		this.login = pLogin;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pPswd) {
		this.pswd = pPswd;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role pRole) {
		this.role = pRole;
	}
	
	
}
