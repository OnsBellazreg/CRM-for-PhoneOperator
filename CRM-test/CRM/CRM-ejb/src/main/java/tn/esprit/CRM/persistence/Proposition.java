package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Proposition
 *
 */
@Entity

public class Proposition implements Serializable {

	   
	@Id
	private Integer id_proposition;
	private String Description;
	private Integer oui;
	private Integer non;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user3;
	
	
	public User getUser3() {
		return user3;
	}
	public void setUser3(User user3) {
		this.user3 = user3;
	}
	public Proposition() {
		super();
	}   
	public Integer getId_proposition() {
		return this.id_proposition;
	}

	public void setId_proposition(Integer id_proposition) {
		this.id_proposition = id_proposition;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	public Integer getOui() {
		return oui;
	}
	public void setOui(Integer oui) {
		this.oui = oui;
	}
	public Integer getNon() {
		return non;
	}
	public void setNon(Integer non) {
		this.non = non;
	}
   
}
