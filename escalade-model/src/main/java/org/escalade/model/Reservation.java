package org.escalade.model;

public class Reservation {
	private int id;
	private Topo topo;
	private User userDemandeur;
	
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
	
	
}
