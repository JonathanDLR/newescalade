package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	private int id;
	private String login;
	private String pswd;
	private Role role;
	
	// GETTERS SETTERS //
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	
	@Column(name = "loginn")
	public String getLogin() {
		return login;
	}
	public void setLogin(String pLogin) {
		this.login = pLogin;
	}
	
	@Column(name = "pswd")
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pPswd) {
		this.pswd = pPswd;
	}
	
	@Column(name = "role")
	public Role getRole() {
		return role;
	}
	public void setRole(Role pRole) {
		this.role = pRole;
	}
}
