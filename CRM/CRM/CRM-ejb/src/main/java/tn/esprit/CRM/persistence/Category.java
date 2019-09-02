package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	@Id
	private Integer id_category;
	private String category_type;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="categorie")
	private List<Product> produits1;

	@OneToMany(mappedBy="category")
	private List<Brand> brands;
	
	
	
	public List<Brand> getBrands() {
		return brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
	public List<Product> getProduits1() {
		return produits1;
	}
	public void setProduits1(List<Product> produits1) {
		this.produits1 = produits1;
	}
	public Category() {
		super();
	}   
	public Integer getId_category() {
		return this.id_category;
	}

	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}   
	public String getCategory_type() {
		return this.category_type;
	}

	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
   
}
