package tn.esprit.CRM.presentation.mbeans;

import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.services.StaffService;

@ManagedBean//(name="congeBean")
@SessionScoped
public class CongeBean {

	public StaffService getService() {
		return service;
	}

	public void setService(StaffService service) {
		this.service = service;
	}

	private int id_co;
	private Date date_co;
	private String type_co;
	private String certificat;
	private int nbjrs_co;
	private String status_co;
	private int cin;
	
	public int getId_co() {
		return id_co;
	}

	public void setId_co(int id_co) {
		this.id_co = id_co;
	}

	public Date getDate_co() {
		return date_co;
	}

	public void setDate_co(Date date_co) {
		this.date_co = date_co;
	}

	public String getType_co() {
		return type_co;
	}

	public void setType_co(String type_co) {
		this.type_co = type_co;
	}

	public String getCertificat() {
		return certificat;
	}

	public void setCertificat(String certificat) {
		this.certificat = certificat;
	}

	public int getNbjrs_co() {
		return nbjrs_co;
	}

	public void setNbjrs_co(int nbjrs_co) {
		this.nbjrs_co = nbjrs_co;
	}

	public String getStatus_co() {
		return status_co;
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

	@EJB
	StaffService service;
	
	
	public CongeBean() {
		
		// TODO Auto-generated constructor stub
	}

	private List<Conge> conges;

	public List<Conge> getConges() {
		conges= service.FindAllDemandeConge();
		return conges;
	}

	public CongeBean(int id_co, Date date_co, String type_co, String certificat, int nbjrs_co, String status_co,
			int cin, List<Conge> conges) {
		super();
		this.id_co = id_co;
		this.date_co = date_co;
		this.type_co = type_co;
		this.certificat = certificat;
		this.nbjrs_co = nbjrs_co;
		this.status_co = status_co;
		this.cin = cin;
		this.conges = conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	
	
	
}
