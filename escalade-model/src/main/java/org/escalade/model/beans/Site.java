package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site {
	private int id;
	private String nom;
	private Lieu lieu;
	private Cotation cotation;
	private int nbreSecteur;
	private boolean officiel;
	
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
	
	@Column(name  = "nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String pNom) {
		this.nom = pNom;
	}
	
	@Column(name = " lieu")
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu pLieu) {
		this.lieu = pLieu;
	}
	
	@Column(name = "cotation")
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation pCotation) {
		this.cotation = pCotation;
	}
	
	@Column(name = "nbre_secteur")
	public int getNbreSecteur() {
		return nbreSecteur;
	}
	public void setNbreSecteur(int pNbreSecteur) {
		this.nbreSecteur = pNbreSecteur;
	}
	
	@Column(name = "officiel")
	public boolean isOfficiel() {
		return officiel;
	}
	public void setOfficiel(boolean pOfficiel) {
		this.officiel = pOfficiel;
	}
	
	
}
