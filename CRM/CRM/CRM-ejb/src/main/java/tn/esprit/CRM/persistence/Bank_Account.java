package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bank_Account
 *
 */
@Entity

public class Bank_Account implements Serializable {

	   
	@Id
	private Integer id_account;
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="bank_account")
	private User user5;
	
	
	public User getUser5() {
		return user5;
	}
	public void setUser5(User user5) {
		this.user5 = user5;
	}
	public Bank_Account() {
		super();
	}   
	public Integer getId_account() {
		return this.id_account;
	}

	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}
   
}
