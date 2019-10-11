package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Commentaire {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "comm")
	private String comm;
	
	@ManyToOne
	@JoinColumn(name = "user_auteur")
	private User userAuteur;
	
	@ManyToOne
	@JoinColumn(name = "site")
	private Site site;
	
	// GETTERS SETTERS //
	
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	
	public String getComm() {
		return comm;
	}
	public void setComm(String pComm) {
		this.comm = pComm;
	}
	
	public User getUserAuteur() {
		return userAuteur;
	}
	public void setUserAuteur(User pUser_auteur) {
		this.userAuteur = pUser_auteur;
	}

	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
