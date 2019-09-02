package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Shopping_List
 *
 */
@Entity

public class Shopping_List implements Serializable {

	   
	@Id
	private Integer id_shopp;
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy="shop")
	private User user1;

	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public Shopping_List() {
		super();
	}   
	public Integer getId_shopp() {
		return this.id_shopp;
	}

	public void setId_shopp(Integer id_shopp) {
		this.id_shopp = id_shopp;
	}
   
}
