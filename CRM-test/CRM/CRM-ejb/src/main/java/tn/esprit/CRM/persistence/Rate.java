package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rate
 *
 */
@Entity

public class Rate implements Serializable {

	   
	@Id
	private Integer id_rate;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Staff staff;
	
	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Rate() {
		super();
	}   
	public Integer getId_rate() {
		return this.id_rate;
	}

	public void setId_rate(Integer id_rate) {
		this.id_rate = id_rate;
	}
   
}
