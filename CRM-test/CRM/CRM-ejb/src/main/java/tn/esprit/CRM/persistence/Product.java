package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   
	@Id
	private Integer id_product;
	private String name_product;
	private Integer quantity_product;
	private Float price_product;
	private String description_product;
	private String picture_product;
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Abonnement abonnement;
	
	@ManyToOne
	private Category categorie;
	
	@ManyToOne
	private Basket basket;
	
	
	
	
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	public Category getCategorie() {
		return categorie;
	}
	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public Product() {
		super();
	}   
	public Integer getId_product() {
		return this.id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}   
	public String getName_product() {
		return this.name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}   
	public Integer getQuantity_product() {
		return this.quantity_product;
	}

	public void setQuantity_product(Integer quantity_product) {
		this.quantity_product = quantity_product;
	}   
	public Float getPrice_product() {
		return this.price_product;
	}

	public void setPrice_product(Float price_product) {
		this.price_product = price_product;
	}   
	public String getDescription_product() {
		return this.description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}   
	public String getPicture_product() {
		return this.picture_product;
	}

	public void setPicture_product(String picture_product) {
		this.picture_product = picture_product;
	}
   
}
