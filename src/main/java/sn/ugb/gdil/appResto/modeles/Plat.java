package sn.ugb.gdil.appResto.modeles;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Plat implements Serializable   {
	public Plat() {};

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	public Plat(Long id, String nom, String description, String type, String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.image = image;
	}
	@Id
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false, updatable = true)
	private String nom;
	private String description;
	private String type;
	private String image;
	

	 


}
