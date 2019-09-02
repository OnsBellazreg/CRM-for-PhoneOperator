package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pack
 *
 */
@Entity

public class Pack implements Serializable {

	   
	@Id
	private Integer id_pack;
	private Date start_date_pack;
	private Date end_date_pack;
	private Float price_pack;
	private String title_pack;
	private Integer numbre;
	private Float percent_gain;
	private String description_pack;
	private Boolean visibily_pack;
	private static final long serialVersionUID = 1L;

	public Pack() {
		super();
	}   
	public Integer getId_pack() {
		return this.id_pack;
	}

	public void setId_pack(Integer id_pack) {
		this.id_pack = id_pack;
	}   
	public Date getStart_date_pack() {
		return this.start_date_pack;
	}

	public void setStart_date_pack(Date start_date_pack) {
		this.start_date_pack = start_date_pack;
	}   
	public Date getEnd_date_pack() {
		return this.end_date_pack;
	}

	public void setEnd_date_pack(Date end_date_pack) {
		this.end_date_pack = end_date_pack;
	}   
	public Float getPrice_pack() {
		return this.price_pack;
	}

	public void setPrice_pack(Float price_pack) {
		this.price_pack = price_pack;
	}   
	public String getTitle_pack() {
		return this.title_pack;
	}

	public void setTitle_pack(String title_pack) {
		this.title_pack = title_pack;
	}   
	public Integer getNumbre() {
		return this.numbre;
	}

	public void setNumbre(Integer numbre) {
		this.numbre = numbre;
	}   
	public Float getPercent_gain() {
		return this.percent_gain;
	}

	public void setPercent_gain(Float percent_gain) {
		this.percent_gain = percent_gain;
	}   
	public String getDescription_pack() {
		return this.description_pack;
	}

	public void setDescription_pack(String description_pack) {
		this.description_pack = description_pack;
	}   
	public Boolean getVisibily_pack() {
		return this.visibily_pack;
	}

	public void setVisibily_pack(Boolean visibily_pack) {
		this.visibily_pack = visibily_pack;
	}
   
}
