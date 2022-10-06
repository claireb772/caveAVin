package fr.eni.tpcaveAVin.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Couleur {

	@Id
	@GeneratedValue
	private int id;

	private String nom;

	public Couleur() {
	}

	public Couleur(String nom) {
		super();
		this.nom = nom;
	}

	public Couleur(int id, String nom) {
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
