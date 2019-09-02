package tn.esprit.CRM.presentation.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tn.esprit.CRM.persistence.Reclamation;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.Type_reclamation;
import tn.esprit.CRM.services.ReclamationServiceLocal;


@ManagedBean
@SessionScoped
public class ReclamationBean {
	
	public ReclamationBean() {
	
	}

	private List<Reclamation> conge = new ArrayList<Reclamation>();
	private List<Reclamation> congeez = new ArrayList<Reclamation>();
	private List<Staff> Users = new ArrayList<Staff>();
	private Reclamation Reclamation = new Reclamation();
	private Reclamation r=new Reclamation();
	private RepeatPaginator paginator;
	@ManagedProperty("#{identity}")
	//private Identity identity;
	private Integer id_recl;
	private Integer id_client;
	@Enumerated(EnumType.STRING)
	private Type_reclamation type_reclamation;
	private String description_recl;
	private String status_recl;
	private Date date_sent;
	private String Branche;
	@EJB
	private ReclamationServiceLocal Service;
	private Reclamation SelectedTable;
	Date d = new Date();
	private boolean formDisplay = false;

	public String doDeleteCo(int id) {
		Service.SupprimerReclamation(r);
		intitialization();
		paginator = new RepeatPaginator(conge);
		String n = "/template/index3?faces-redirect=true";

		return n;
	}

	public String doUpdate() {
		System.out.println("seeeeeeeeeeelecyed table ::::::" + SelectedTable.getId_recl());
		Service.ModifierReclamation(SelectedTable);
		//demandeCongeServiceLocal.UpdateDemandeConge(SelectedTable);
		intitialization();

		String n = "/AddConge?faces-redirect=true";
		return n;
	}

	public String affiche() {
		System.out.println("mm" + SelectedTable.toString());
		intitialization();
		String n = "/AddConge?faces-redirect=true";

		return n;
	}

	public String doRemove(Reclamation Reclamation) {

		Service.SupprimerReclamation(Reclamation);
		intitialization();
		// formDisplay = false;
		// paginator = new RepeatPaginator(congeez);
		Reclamation = new Reclamation();
		String n = "/AddConge?faces-redirect=true";
		return n;

	}
	@PostConstruct
	public void intitialization() {
		congeez = Service.AfficherReclamation();
	}

	public List<Reclamation> getConge() {
		return conge;
	}

	public void setConge(List<Reclamation> conge) {
		this.conge = conge;
	}

	public List<Reclamation> getCongeez() {
		return congeez;
	}

	public void setCongeez(List<Reclamation> congeez) {
		this.congeez = congeez;
	}

	public List<Staff> getUsers() {
		return Users;
	}

	public void setUsers(List<Staff> users) {
		Users = users;
	}

	public Reclamation getReclamation() {
		return Reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		Reclamation = reclamation;
	}

	public Reclamation getR() {
		return r;
	}

	public void setR(Reclamation r) {
		this.r = r;
	}

	public RepeatPaginator getPaginator() {
		return paginator;
	}

	public void setPaginator(RepeatPaginator paginator) {
		this.paginator = paginator;
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

	public String getBranche() {
		return Branche;
	}

	public void setBranche(String branche) {
		Branche = branche;
	}

	public ReclamationServiceLocal getService() {
		return Service;
	}

	public void setService(ReclamationServiceLocal service) {
		Service = service;
	}

	public Reclamation getSelectedTable() {
		return SelectedTable;
	}

	public void setSelectedTable(Reclamation selectedTable) {
		SelectedTable = selectedTable;
	}

	public boolean isFormDisplay() {
		return formDisplay;
	}

	public void setFormDisplay(boolean formDisplay) {
		this.formDisplay = formDisplay;
	}


}
