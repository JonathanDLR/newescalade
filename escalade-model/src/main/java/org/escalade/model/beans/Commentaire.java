package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commentaire")
public class Commentaire {
	private int id;
	private String comm;
	private User userAuteur;
	private Site site;
	
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
	
	@Column(name = "comm")
	public String getComm() {
		return comm;
	}
	public void setComm(String pComm) {
		this.comm = pComm;
	}
	
	@Column(name ="user_auteur")
	public User getUserAuteur() {
		return userAuteur;
	}
	public void setUserAuteur(User pUser_auteur) {
		this.userAuteur = pUser_auteur;
	}
	
	@Column(name = "site")
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
