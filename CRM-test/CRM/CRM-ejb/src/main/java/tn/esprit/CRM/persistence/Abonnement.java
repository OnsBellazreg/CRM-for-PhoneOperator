package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Abonnement
 *
 */
@Entity

public class Abonnement implements Serializable {

	   
	@Id
	private Integer id_abonnement;
	private Integer number_month;
	private Float price_per_month;
	private Date start_date_abonnement;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="abonnement")
	private Product produit ;
	
	
	public Product getProduit() {
		return produit;
	}
	public void setProduit(Product produit) {
		this.produit = produit;
	}
	public Abonnement()  {
		super();
	}   
	public Integer getId_abonnement() {
		return this.id_abonnement;
	}

	public void setId_abonnement(Integer id_abonnement) {
		this.id_abonnement = id_abonnement;
	}   
	public Integer getNumber_month() {
		return this.number_month;
	}

	public void setNumber_month(Integer number_month) {
		this.number_month = number_month;
	}   
	public Float getPrice_per_month() {
		return this.price_per_month;
	}

	public void setPrice_per_month(Float price_per_month) {
		this.price_per_month = price_per_month;
	}   
	public Date getStart_date_abonnement() {
		return this.start_date_abonnement;
	}

	public void setStart_date_abonnement(Date start_date_abonnement) {
		this.start_date_abonnement = start_date_abonnement;
	}
   
}
