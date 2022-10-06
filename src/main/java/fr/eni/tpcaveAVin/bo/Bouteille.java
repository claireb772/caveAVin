package fr.eni.tpcaveAVin.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Bouteille {

	@Id
	@GeneratedValue
	private int id;

	@NotNull(message = "Le nom est obligatoire et il contient entre 5 et 50 caractères")
	@Size(min = 5, max = 50, message = "La taille du nom est comprise entre 5 et 50 caractères")
	private String nom;
	private boolean isPetillant;
	private String millesime;

	@Min(value = 1, message = "Votre quantité de bouteille est insuffisante")
	private int quantite;

	@NotNull(message = "La couleur est obligatoire")
	@ManyToOne
	private Couleur couleur;

	@NotNull(message = "La région est obligatoire")
	@ManyToOne
	private Region region;

	public Bouteille() {
		couleur = new Couleur();
		region = new Region();
	}

	public Bouteille(String nom, boolean isPetillant, String millesime, int quantite) {
		this.nom = nom;
		this.isPetillant = isPetillant;
		this.millesime = millesime;
		this.quantite = quantite;
	}

	public Bouteille(int id, String nom, boolean isPetillant, String millesime, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.isPetillant = isPetillant;
		this.millesime = millesime;
		this.quantite = quantite;
	}

	public Bouteille(int id, @Size(min = 5, max = 50) String nom, boolean isPetillant, String millesime,
			@Min(1) int quantite, @NotNull(message = "La couleur est obligatoire") Couleur couleur,
			@NotNull(message = "La région est obligatoire") Region region) {
		super();
		this.id = id;
		this.nom = nom;
		this.isPetillant = isPetillant;
		this.millesime = millesime;
		this.quantite = quantite;
		this.couleur = couleur;
		this.region = region;
	}

	public Bouteille(@Size(min = 5, max = 50) String nom, boolean isPetillant, String millesime, @Min(1) int quantite,
			@NotNull(message = "La couleur est obligatoire") Couleur couleur,
			@NotNull(message = "La région est obligatoire") Region region) {
		super();
		this.nom = nom;
		this.isPetillant = isPetillant;
		this.millesime = millesime;
		this.quantite = quantite;
		this.couleur = couleur;
		this.region = region;
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

	public boolean isPetillant() {
		return isPetillant;
	}

	public void setPetillant(boolean isPetillant) {
		this.isPetillant = isPetillant;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Bouteille [id=" + id + ", nom=" + nom + ", isPetillant=" + isPetillant + ", millesime=" + millesime
				+ ", quantite=" + quantite + "]";
	}

}
