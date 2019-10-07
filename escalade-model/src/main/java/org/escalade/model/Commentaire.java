package org.escalade.model;

public class Commentaire {
	private int id;
	private String comm;
	private User userAuteur;
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
	public User getUser_auteur() {
		return userAuteur;
	}
	public void setUser_auteur(User pUser_auteur) {
		this.userAuteur = pUser_auteur;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
