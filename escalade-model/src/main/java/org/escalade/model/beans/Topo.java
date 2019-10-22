package org.escalade.model.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.escalade.model.annotation.DateConstraint;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "topo")
public class Topo {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", unique = true)
	@NotEmpty(message = "Veuillez renseigner le nom.")
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT")
	@NotEmpty(message = "Veuillez renseigner une description.")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lieu")
	private Lieu lieu;
	
	@Column(name = "date_parution")
	@NotNull(message = "Veuillez rentrer la date de parution.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
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
