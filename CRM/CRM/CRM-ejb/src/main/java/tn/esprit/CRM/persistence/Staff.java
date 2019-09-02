package tn.esprit.CRM.persistence;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Staff
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Staff extends User implements Serializable {

	
	private int disponibilite;
	private int nbjrscp;
	private int yearswork;
	private float salary_staff;
	private int increase;
	
	private static final long serialVersionUID = 1L;
	@ManyToMany
	private List<Conge> conges;
	
	@OneToMany(mappedBy="staff",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Rate> rates;

	@OneToMany(mappedBy="staff1")
	private List<RatePk> rates1;
	
	
	
	

	@Override
	public String toString() {
		return "Staff [disponibilite=" + disponibilite + ", nbjrscp=" + nbjrscp + ", yearswork=" + yearswork
				+ ", salary_staff=" + salary_staff + ", increase=" + increase + "]";
	}
	public List<RatePk> getRates1() {
		return rates1;
	}
	public void setRates1(List<RatePk> rates1) {
		this.rates1 = rates1;
	}
	public List<Rate> getRates() {
		return rates;
	}
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	public List<Conge> getConges() {
		return conges;
	}
	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	public Staff() {
		super();
	}
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}
	public int getNbjrscp() {
		return nbjrscp;
	}
	public void setNbjrscp(int nbjrscp) {
		this.nbjrscp = nbjrscp;
	}
	public int getYearswork() {
		return yearswork;
	}
	public void setYearswork(int yearswork) {
		this.yearswork = yearswork;
	}
	public float getSalary_staff() {
		return salary_staff;
	}
	public void setSalary_staff(float salary_staff) {
		this.salary_staff = salary_staff;
	}
	public int getIncrease() {
		return increase;
	}
	public void setIncrease(int increase) {
		this.increase = increase;
	}
	public Staff(String first_Name, String user_Name, int disponibilite, int nbjrscp, int yearswork, float salary_staff,
			int increase) {
		super(first_Name, user_Name);
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
	}
	public Staff(int disponibilite, int nbjrscp, int yearswork, float salary_staff, int increase) {
		super();
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
	}
	public Staff(Integer id_user, String first_Name, String last_Name) {
		super(id_user, first_Name, last_Name);
		// TODO Auto-generated constructor stub
	}
	public Staff(String first_Name, String user_Name) {
		super(first_Name, user_Name);
		// TODO Auto-generated constructor stub
	}
	public Staff(String first_Name, String user_Name, int disponibilite, int nbjrscp, int yearswork, float salary_staff,
			int increase, List<Conge> conges) {
		super(first_Name, user_Name);
		this.disponibilite = disponibilite;
		this.nbjrscp = nbjrscp;
		this.yearswork = yearswork;
		this.salary_staff = salary_staff;
		this.increase = increase;
		this.conges = conges;
	}
	public Staff(String first_Name, String last_Name, Integer cIN) {
		super(first_Name, last_Name, cIN);
		// TODO Auto-generated constructor stub
	}
	

}
