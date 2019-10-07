package org.escalade.model;

import java.util.Date;

public class Topo {
	private int id;
	private String name;
	private String description;
	private Lieu lieu;
	private Date dateParution;
	private boolean disponible;
	private User user;
	
	// GETTERS SETTERS //
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		this.name = pName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String pDescription) {
		this.description = pDescription;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu pLieu) {
		this.lieu = pLieu;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date pDateParution) {
		this.dateParution = pDateParution;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean pDisponible) {
		this.disponible = pDisponible;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User pUser) {
		this.user = pUser;
	}
	
	
}
