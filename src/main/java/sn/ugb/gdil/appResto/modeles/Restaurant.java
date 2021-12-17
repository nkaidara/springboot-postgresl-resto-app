package sn.ugb.gdil.appResto.modeles;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Restaurant implements Serializable {
	public Restaurant() {};
	
	public Restaurant(Long id, String nom, String adresse, String telephone, String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false, updatable = true)
	private String nom;
	private String adresse;
	private String telephone;
	private String image;
	
	 @ManyToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
	 List<Plat> plats;
	
	 public List<Plat> getPlats() { return plats; }
	 
	 public void setPlats(List<Plat> plats) { this.plats = plats; }
	 
	 public void ajouterPlat(Plat plat) {
		 this.plats.add(plat);
	 }
	 

	

}
