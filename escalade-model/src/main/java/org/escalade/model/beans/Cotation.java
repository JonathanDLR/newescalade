package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotation")
public class Cotation {
	private int id;
	private String cot;
	
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
	
	@Column(name = "cot")
	public String getCot() {
		return cot;
	}
	public void setCot(String pCot) {
		this.cot = pCot;
	}	
}
