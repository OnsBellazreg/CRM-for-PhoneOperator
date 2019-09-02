package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bill
 *
 */
@Entity

public class Bill implements Serializable {

	   
	@Id
	private Integer id_bill;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="bill")
	private Basket basket;
	
	
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	public Bill() {
		super();
	}   
	public Integer getId_bill() {
		return this.id_bill;
	}

	public void setId_bill(Integer id_bill) {
		this.id_bill = id_bill;
	}
   
}
