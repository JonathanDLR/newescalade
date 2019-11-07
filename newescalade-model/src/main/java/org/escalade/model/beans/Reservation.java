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
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "topo")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User userDemandeur;
	
	@Column(name = "processed")
	private Boolean processed;
	
	// GETTERS SETTERS //
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo pTopo) {
		this.topo = pTopo;
	}
	
	public User getUserDemandeur() {
		return userDemandeur;
	}
	public void setUserDemandeur(User pUserDemandeur) {
		this.userDemandeur = pUserDemandeur;
	}
	
	public Boolean getProcessed() {
		return processed;
	}
	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}	
}
