package org.escalade.model;

public class Site {
	private int id;
	private String nom;
	private Lieu lieu;
	private Cotation cotation;
	private int nbreSecteur;
	private boolean officiel;
	
	// GETTERS SETTERS //
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String pNom) {
		this.nom = pNom;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu pLieu) {
		this.lieu = pLieu;
	}
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation pCotation) {
		this.cotation = pCotation;
	}
	public int getNbre_secteur() {
		return nbreSecteur;
	}
	public void setNbre_secteur(int pNbreSecteur) {
		this.nbreSecteur = pNbreSecteur;
	}
	public boolean isOfficiel() {
		return officiel;
	}
	public void setOfficiel(boolean pOfficiel) {
		this.officiel = officiel;
	}
	
	
}
