package fr.eni.tpcaveAVin.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Region {

	@Id
	@GeneratedValue
	private int id;

	private String nom;

	public Region() {
	}

	public Region(String nom) {
		super();
		this.nom = nom;
	}

	public Region(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
