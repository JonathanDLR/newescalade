package org.escalade.model.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topo")
public class Topo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "topos")
	private Set<Site> sites;
	
	@Column(name = "date_parution")
	private Date dateParution;
	
	@Column(name = "disponible")
	private boolean disponible;
	
	@ManyToOne
	@JoinColumn(name = "user")
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

	public Set<Site> getSites() {
		return sites;
	}
	public void setSites(Set<Site> sites) {
		this.sites = sites;
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
