package org.escalade.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lieu")
public class Lieu {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
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
	
	
}
