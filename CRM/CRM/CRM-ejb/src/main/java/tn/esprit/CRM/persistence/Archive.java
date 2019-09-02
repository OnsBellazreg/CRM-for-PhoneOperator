package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity

public class Archive implements Serializable {
	
	@Id
	private Integer id_recl;
	private Integer id_client;
	@Enumerated(EnumType.STRING)
	private Type_reclamation type_reclamation;
	private String description_recl;
	private String status_recl;
	private Date date_sent;
	private String Status;
	private static final long serialVersionUID = 1L;

	public Archive() {
		super();
	}

	public Integer getId_recl() {
		return id_recl;
	}

	public void setId_recl(Integer id_recl) {
		this.id_recl = id_recl;
	}

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public Type_reclamation getType_reclamation() {
		return type_reclamation;
	}

	public void setType_reclamation(Type_reclamation type_reclamation) {
		this.type_reclamation = type_reclamation;
	}

	public String getDescription_recl() {
		return description_recl;
	}

	public void setDescription_recl(String description_recl) {
		this.description_recl = description_recl;
	}

	public String getStatus_recl() {
		return status_recl;
	}

	public void setStatus_recl(String status_recl) {
		this.status_recl = status_recl;
	}

	public Date getDate_sent() {
		return date_sent;
	}

	public void setDate_sent(Date date_sent) {
		this.date_sent = date_sent;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Archive [id_recl=" + id_recl + ", id_client=" + id_client + ", type_reclamation=" + type_reclamation
				+ ", description_recl=" + description_recl + ", status_recl=" + status_recl + ", date_sent=" + date_sent
				+ ", Status=" + Status + "]";
	}
	
}
