package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity

public class Conge implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id_co;
	private Date date_co;
	private String type_co;
	private String certificat;
	private int nbjrs_co;
	private String status_co;
	private int cin;
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="conges",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Staff> staffs;
	
	@OneToOne
	private User user;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	public Conge() {
		super();
	}   
	public Integer getId_co() {
		return this.id_co;
	}

	public void setId_co(Integer id_co) {
		this.id_co = id_co;
	}   
	public Date getDate_co() {
		return this.date_co;
	}

	public void setDate_co(Date date_co) {
		this.date_co = date_co;
	}   
	public String getType_co() {
		return this.type_co;
	}

	public void setType_co(String type_co) {
		this.type_co = type_co;
	}   
	public String getCertificat() {
		return this.certificat;
	}

	public void setCertificat(String certificat) {
		this.certificat = certificat;
	}   
	public Integer getNbjrs_co() {
		return this.nbjrs_co;
	}

	public void setNbjrs_co(Integer nbjrs_co) {
		this.nbjrs_co = nbjrs_co;
	}   
	public String getStatus_co() {
		return this.status_co;
	}

	public void setStatus_co(String status_co) {
		this.status_co = status_co;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Conge(Date date_co, String type_co, String certificat, int nbjrs_co, String status_co, int cin) {
		super();
		this.date_co = date_co;
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
	}

	public Conge(String type_co, String certificat, int nbjrs_co, String status_co, int cin) {
		super();
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId_co(int id_co) {
		this.id_co = id_co;
	}

	@Override
	public String toString() {
		return "Conge [id_co=" + id_co + ", date_co=" + date_co + ", type_co=" + type_co + ", certificat=" + certificat
				+ ", nbjrs_co=" + nbjrs_co + ", status_co=" + status_co + ", cin=" + cin
				;
	}

	public void setNbjrs_co(int nbjrs_co) {
		this.nbjrs_co = nbjrs_co;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status_co == null) ? 0 : status_co.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conge other = (Conge) obj;
		if (status_co == null) {
			if (other.status_co != null)
				return false;
		} else if (!status_co.equals(other.status_co))
			return false;
		return true;
	}
	
}
