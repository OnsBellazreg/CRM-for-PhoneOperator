package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity

public class Offre implements Serializable {

	   
	@Id
	private Integer id_offre;
	private String title_offre;
	private Date start_date_offre;
	private Date end_date_offre;
	private Boolean visibility_offre;
	private Float percent_gain_offre;
	private static final long serialVersionUID = 1L;

	public Offre() {
		super();
	}   
	public Integer getId_offre() {
		return this.id_offre;
	}

	public void setId_offre(Integer id_offre) {
		this.id_offre = id_offre;
	}   
	public String getTitle_offre() {
		return this.title_offre;
	}

	public void setTitle_offre(String title_offre) {
		this.title_offre = title_offre;
	}   
	public Date getStart_date_offre() {
		return this.start_date_offre;
	}

	public void setStart_date_offre(Date start_date_offre) {
		this.start_date_offre = start_date_offre;
	}   
	public Date getEnd_date_offre() {
		return this.end_date_offre;
	}

	public void setEnd_date_offre(Date end_date_offre) {
		this.end_date_offre = end_date_offre;
	}   
	public Boolean getVisibility_offre() {
		return this.visibility_offre;
	}

	public void setVisibility_offre(Boolean visibility_offre) {
		this.visibility_offre = visibility_offre;
	}   
	public Float getPercent_gain_offre() {
		return this.percent_gain_offre;
	}

	public void setPercent_gain_offre(Float percent_gain_offre) {
		this.percent_gain_offre = percent_gain_offre;
	}
   
}
