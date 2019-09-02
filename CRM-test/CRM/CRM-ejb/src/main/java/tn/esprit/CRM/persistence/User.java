package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import tn.esprit.CRM.persistence.Task;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_user;
	private String first_Name;
	private String last_Name;
	private String user_Name;
	private String password;
	private String email;
	private Integer phone_number;
	private String address;
	private Integer CIN;
	private Date account_Date;
	private Date modified_Date;
	private Integer state_Account;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="user",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Task> tasks;
	
	@OneToOne
	private Shopping_List shop;
	
	@OneToMany(mappedBy="user2",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Quotation> quotations;
	
	@ManyToMany
	private List<Forum> forums;
	
	@OneToMany(mappedBy="user3",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Proposition> propositions;
	
	
	@OneToMany(mappedBy="user4",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Answer> answers;
	
	@OneToOne
	private Bank_Account bank_account;
	
	@ManyToMany
	private List<Calendar> calendars;
	
	
	
	
	
	public User(String first_Name, String user_Name) {
		super();
		this.first_Name = first_Name;
		this.user_Name = user_Name;
	}
	public List<Calendar> getCalendar() {
		return calendars;
	}
	public User(String first_Name, String last_Name, Integer cIN) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		CIN = cIN;
	}
	public void setCalendar(List<Calendar> calendars) {
		this.calendars = calendars;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Bank_Account getBank_account() {
		return bank_account;
	}
	public void setBank_account(Bank_Account bank_account) {
		this.bank_account = bank_account;
	}
	public List<Proposition> getPropositions() {
		return propositions;
	}
	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	public List<Forum> getForums() {
		return forums;
	}
	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}
	public List<Quotation> getQuotations() {
		return quotations;
	}
	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}
	public Shopping_List getShop() {
		return shop;
	}
	public void setShop(Shopping_List shop) {
		this.shop = shop;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public User() {
		super();
	}   
	public Integer getId_user() {
		return this.id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}   
	public String getFirst_Name() {
		return this.first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}   
	public String getLast_Name() {
		return this.last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}   
	public String getUser_Name() {
		return this.user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Integer getPhone_number() {
		return this.phone_number;
	}

	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Integer getCIN() {
		return this.CIN;
	}

	public void setCIN(Integer CIN) {
		this.CIN = CIN;
	}   
	public Date getAccount_Date() {
		return this.account_Date;
	}

	public void setAccount_Date(Date account_Date) {
		this.account_Date = account_Date;
	}   
	public Date getModified_Date() {
		return this.modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}   
	public Integer getState_Account() {
		return this.state_Account;
	}

	public void setState_Account(Integer state_Account) {
		this.state_Account = state_Account;
	}
	public User(Integer id_user, String first_Name, String last_Name) {
		super();
		this.id_user = id_user;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
	}
	public List<Calendar> getCalendars() {
		return calendars;
	}
	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}
	
   
}
