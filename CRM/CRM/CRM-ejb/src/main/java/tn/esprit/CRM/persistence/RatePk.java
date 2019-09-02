package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RatePk
 *
 */
@Entity

public class RatePk implements Serializable {

	   
	@Id
	private Integer id_ratepk;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Staff staff1;
	
	
	
	public Staff getStaff1() {
		return staff1;
	}
	public void setStaff1(Staff staff1) {
		this.staff1 = staff1;
	}
	public RatePk() {
		super();
	}   
	public Integer getId_ratepk() {
		return this.id_ratepk;
	}

	public void setId_ratepk(Integer id_ratepk) {
		this.id_ratepk = id_ratepk;
	}
   
}
