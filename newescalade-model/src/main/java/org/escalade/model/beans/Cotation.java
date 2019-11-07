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
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cot")
	private String cot;
	
	// GETTERS SETTERS //
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		this.id = pId;
	}
	
	public String getCot() {
		return cot;
	}
	public void setCot(String pCot) {
		this.cot = pCot;
	}	
}
