package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id_recl;
	private Integer id_client;
	@Enumerated(EnumType.STRING)
	private Type_reclamation type_reclamation;
	private String description_recl;
	private String status_recl;
	private Date date_sent;
	private String Branche;
	private static final long serialVersionUID = 1L;

	public Reclamation() {
		super();
	}   
	public Integer getId_recl() {
		return this.id_recl;
	}

	public void setId_recl(Integer id_recl) {
		this.id_recl = id_recl;
	}   
	
	
	public Type_reclamation getType_reclamation() {
		return type_reclamation;
	}
	public void setType_reclamation(Type_reclamation type_reclamation) {
		this.type_reclamation = type_reclamation;
	}
	public String getDescription_recl() {
		return this.description_recl;
	}

	public void setDescription_recl(String description_recl) {
		this.description_recl = description_recl;
	}   
	public String getStatus_recl() {
		return this.status_recl;
	}

	public void setStatus_recl(String status_recl) {
		this.status_recl = status_recl;
	}   
	public Date getDate_sent() {
		return this.date_sent;
	}

	public void setDate_sent(Date date_sent) {
		this.date_sent = date_sent;
	}
	public Integer getId_client() {
		return id_client;
	}
	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}
	@Override
	public String toString() {
		return "Reclamation [id_recl=" + id_recl + ", id_client=" + id_client + ", type_reclamation=" + type_reclamation
				+ ", description_recl=" + description_recl + ", status_recl=" + status_recl + ", date_sent=" + date_sent
				+ ", Branche=" + Branche + "]";
	}
	
}
