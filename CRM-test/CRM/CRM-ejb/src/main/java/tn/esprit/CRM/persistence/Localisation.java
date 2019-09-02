package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Localisation
 *
 */
@Entity

public class Localisation implements Serializable {

	   
	@Id
	private Integer id_localisation;
	private String altitude;
	private String longitude;
	private String name_localisation;
	private String address_loc;
	private String type_localisation;
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Store store;
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Localisation() {
		super();
	}   
	public Integer getId_localisation() {
		return this.id_localisation;
	}

	public void setId_localisation(Integer id_localisation) {
		this.id_localisation = id_localisation;
	}   
	public String getAltitude() {
		return this.altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}   
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}   
	public String getName_localisation() {
		return this.name_localisation;
	}

	public void setName_localisation(String name_localisation) {
		this.name_localisation = name_localisation;
	}   
	public String getAddress_loc() {
		return this.address_loc;
	}

	public void setAddress_loc(String address_loc) {
		this.address_loc = address_loc;
	}   
	public String getType_localisation() {
		return this.type_localisation;
	}

	public void setType_localisation(String type_localisation) {
		this.type_localisation = type_localisation;
	}
   
}
