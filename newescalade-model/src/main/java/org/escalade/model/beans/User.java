package org.escalade.model.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "loginn", unique = true)
	@NotEmpty(message = "Veuillez renseigner votre mail.")
	private String login;
	
	@Column(name = "pswd")
	@NotEmpty(message = "Veuillez renseigner votre mot de passe.")
	private String pswd;
	
	@Column(name ="pseudo")
	@NotEmpty(message = "Veuillez renseigner votre pseudo.")
	private String pseudo;
	
	@ManyToOne
	@JoinColumn(name = "role")
	private Role role;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Topo> topos;
	
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
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pPseudo) {
		this.pseudo = pPseudo;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role pRole) {
		this.role = pRole;
	}
	
	public List<Topo> getTopos() {
		return topos;
	}
	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}
}
