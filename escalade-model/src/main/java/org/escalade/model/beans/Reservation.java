package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	private int id;
	private Topo topo;
	private User userDemandeur;
	
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
	
	@Column(name = "topo")
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo pTopo) {
		this.topo = pTopo;
	}
	
	@Column(name = "user_demandeur")
	public User getUserDemandeur() {
		return userDemandeur;
	}
	public void setUserDemandeur(User pUserDemandeur) {
		this.userDemandeur = pUserDemandeur;
	}
	
	
}
