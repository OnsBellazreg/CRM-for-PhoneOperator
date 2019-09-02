package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ligne_offre
 *
 */
@Entity

public class Ligne_offre implements Serializable {

	   
	@Id
	private Integer id_ligne_offre;
	private Integer id_offre;
	private Integer id_service;
	private Integer quantity;
	private Date end_date;
	private static final long serialVersionUID = 1L;

	public Ligne_offre() {
		super();
	}   
	public Integer getId_ligne_offre() {
		return this.id_ligne_offre;
	}

	public void setId_ligne_offre(Integer id_ligne_offre) {
		this.id_ligne_offre = id_ligne_offre;
	}   
	public Integer getId_offre() {
		return this.id_offre;
	}

	public void setId_offre(Integer id_offre) {
		this.id_offre = id_offre;
	}   
	public Integer getId_service() {
		return this.id_service;
	}

	public void setId_service(Integer id_service) {
		this.id_service = id_service;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}   
	public Date getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
   
}
