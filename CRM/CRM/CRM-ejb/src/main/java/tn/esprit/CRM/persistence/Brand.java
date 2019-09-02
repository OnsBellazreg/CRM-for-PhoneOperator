package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Brand
 *
 */
@Entity

public class Brand implements Serializable {

	   
	@Id
	private Integer id_brand;
	private String brand_type;
	private String description;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand() {
		super();
	}   
	public Integer getId_brand() {
		return this.id_brand;
	}

	public void setId_brand(Integer id_brand) {
		this.id_brand = id_brand;
	}   
	public String getBrand_type() {
		return this.brand_type;
	}

	public void setBrand_type(String brand_type) {
		this.brand_type = brand_type;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
