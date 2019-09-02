package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ligne_pack
 *
 */
@Entity

public class Ligne_pack implements Serializable {

	   
	@Id
	private Integer id_ligne_pack;
	private Integer id_pack;
	private Integer id_service;
	private static final long serialVersionUID = 1L;

	public Ligne_pack() {
		super();
	}   
	public Integer getId_ligne_pack() {
		return this.id_ligne_pack;
	}

	public void setId_ligne_pack(Integer id_ligne_pack) {
		this.id_ligne_pack = id_ligne_pack;
	}   
	public Integer getId_pack() {
		return this.id_pack;
	}

	public void setId_pack(Integer id_pack) {
		this.id_pack = id_pack;
	}   
	public Integer getId_service() {
		return this.id_service;
	}

	public void setId_service(Integer id_service) {
		this.id_service = id_service;
	}
   
}
