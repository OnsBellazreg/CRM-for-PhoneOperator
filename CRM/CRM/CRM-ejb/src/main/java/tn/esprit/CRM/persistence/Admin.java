package tn.esprit.CRM.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Admin extends User implements Serializable {

	@Enumerated(EnumType.STRING)
	private Admin_type admin_type;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin_type getAdmin_type() {
		return admin_type;
	}

	public void setAdmin_type(Admin_type admin_type) {
		this.admin_type = admin_type;
	}   

	
}
