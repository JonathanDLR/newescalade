package org.escalade.model.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name  = "nom")
	private String nom;
	
	@OneToMany
	private Set<Lieu> lieus;
	
	@ManyToMany
	private Set<Topo> topos;
	
	@ManyToOne
	@JoinColumn(name = "cotation")
	private Cotation cotation;
	
	@Column(name = "nbre_secteur")
	private int nbreSecteur;
	
	@Column(name = "officiel")
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
		
	public Set<Lieu> getLieus() {
		return lieus;
	}
	public void setLieus(Set<Lieu> lieus) {
		this.lieus = lieus;
	}
	
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation pCotation) {
		this.cotation = pCotation;
	}
	
	public int getNbreSecteur() {
		return nbreSecteur;
	}
	public void setNbreSecteur(int pNbreSecteur) {
		this.nbreSecteur = pNbreSecteur;
	}
	
	public boolean isOfficiel() {
		return officiel;
	}
	public void setOfficiel(boolean pOfficiel) {
		this.officiel = pOfficiel;
	}
	
	
}
