package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Basket
 *
 */
@Entity

public class Basket implements Serializable {

	   
	@Id
	private Integer id_basket;
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy="basket")
	private List<Product> Produits;
	
	@OneToOne
	private Bill bill;
	
	
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<Product> getProduits() {
		return Produits;
	}
	
	public void setProduits(List<Product> produits) {
		Produits = produits;
	}
	public Basket() {
		super();
	}   
	public Integer getId_basket() {
		return this.id_basket;
	}

	public void setId_basket(Integer id_basket) {
		this.id_basket = id_basket;
	}
   
}
