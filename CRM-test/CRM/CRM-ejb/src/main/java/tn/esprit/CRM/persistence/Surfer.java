package tn.esprit.CRM.persistence;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.CRM.persistence.User;

/**
 * Entity implementation class for Entity: Surfer
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id_user")
public class Surfer extends User implements Serializable {

	@Enumerated(EnumType.STRING)
	private Type_surfer type_surfer;
	private static final long serialVersionUID = 1L;

	public Surfer() {
		super();
	}

	public Type_surfer getType_surfer() {
		return type_surfer;
	}

	public void setType_surfer(Type_surfer type_surfer) {
		this.type_surfer = type_surfer;
	}   

	
}
