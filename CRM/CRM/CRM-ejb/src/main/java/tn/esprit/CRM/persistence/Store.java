package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Store
 *
 */
@Entity

public class Store implements Serializable {

	   
	@Id
	private Integer id_store;
	private String address_store;
	private Integer employee_number;
	private static final long serialVersionUID = 1L;

	
	@OneToOne(mappedBy="store")
	private Localisation localisation;
	public Store() {
		super();
	}   
	public Integer getId_store() {
		return this.id_store;
	}

	public void setId_store(Integer id_store) {
		this.id_store = id_store;
	}   
	public String getAddress_store() {
		return this.address_store;
	}

	public void setAddress_store(String address_store) {
		this.address_store = address_store;
	}   
	public Integer getEmployee_number() {
		return this.employee_number;
	}

	public void setEmployee_number(Integer employee_number) {
		this.employee_number = employee_number;
	}
   
}
