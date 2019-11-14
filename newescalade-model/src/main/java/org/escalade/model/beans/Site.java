package org.escalade.model.beans;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "site")
public class Site {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Veuillez renseigner le nom du site")
	@Column(name  = "nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "lieu")
	private Lieu lieu;
	
	@ManyToOne
	@JoinColumn(name = "cotation")
	private Cotation cotation;
	
	@Min(value = 1, message = "Veuillez renseigner un nombre supérieur à 0")
	@Column(name = "nbre_secteur")
	private int nbreSecteur;
	
	@Column(name = "officiel")
	private boolean officiel;
	
	@OneToMany(mappedBy = "site", fetch = FetchType.EAGER)
	private List<Commentaire> commentaires;
	
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
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
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
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}
