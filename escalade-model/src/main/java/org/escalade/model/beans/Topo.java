package org.escalade.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topo")
public class Topo {
	private int id;
	private String name;
	private String description;
	private Lieu lieu;
	private Date dateParution;
	private boolean disponible;
	private User user;
	
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
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		this.name = pName;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String pDescription) {
		this.description = pDescription;
	}
	
	@Column(name = "lieu")
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu pLieu) {
		this.lieu = pLieu;
	}
	
	@Column(name = "date_parution")
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date pDateParution) {
		this.dateParution = pDateParution;
	}
	
	@Column(name = "disponible")
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean pDisponible) {
		this.disponible = pDisponible;
	}
	
	@Column(name = "user")
	public User getUser() {
		return user;
	}
	public void setUser(User pUser) {
		this.user = pUser;
	}
	
	
}
