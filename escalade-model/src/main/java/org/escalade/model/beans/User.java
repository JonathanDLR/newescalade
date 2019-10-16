package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.escalade.model.annotation.LoginConstraint;
import org.escalade.model.annotation.PasswordConstraint;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "loginn", unique = true)
	@LoginConstraint
	private String login;
	
	@Column(name = "pswd")
	@PasswordConstraint
	private String pswd;
	
	@ManyToOne
	@JoinColumn(name = "role")
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
