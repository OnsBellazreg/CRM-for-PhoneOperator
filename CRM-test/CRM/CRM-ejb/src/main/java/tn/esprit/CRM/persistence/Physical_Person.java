package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.esprit.CRM.persistence.Surfer;

/**
 * Entity implementation class for Entity: Physical_Person
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Physical_Person extends Surfer implements Serializable {

	
	private String sex;
	private static final long serialVersionUID = 1L;

	public Physical_Person() {
		super();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}   
	
   
}
