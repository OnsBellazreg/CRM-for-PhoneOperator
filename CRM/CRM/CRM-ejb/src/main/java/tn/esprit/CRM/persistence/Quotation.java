package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quotation
 *
 */
@Entity

public class Quotation implements Serializable {

	   
	@Id
	private Integer id_quotation;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private User user2;
	
	

	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	public Quotation() {
		super();
	}   
	public Integer getId_quotation() {
		return this.id_quotation;
	}

	public void setId_quotation(Integer id_quotation) {
		this.id_quotation = id_quotation;
	}
   
}
