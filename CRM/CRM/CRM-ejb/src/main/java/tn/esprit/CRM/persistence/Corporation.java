package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.CRM.persistence.Surfer;

/**
 * Entity implementation class for Entity: Corporation
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Corporation extends Surfer implements Serializable {
	
	private String societyName;
	private String societyAddress;
	private Integer employeesNumber;
	private Integer id_fiscale;
	private static final long serialVersionUID = 1L;

	public Corporation() {
		super();
	}   
	public String getSocietyName() {
		return this.societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}   
	public String getSocietyAddress() {
		return this.societyAddress;
	}

	public void setSocietyAddress(String societyAddress) {
		this.societyAddress = societyAddress;
	}   
	public Integer getEmployeesNumber() {
		return this.employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}   
	public Integer getId_fiscale() {
		return this.id_fiscale;
	}

	public void setId_fiscale(Integer id_fiscale) {
		this.id_fiscale = id_fiscale;
	}
   
}
