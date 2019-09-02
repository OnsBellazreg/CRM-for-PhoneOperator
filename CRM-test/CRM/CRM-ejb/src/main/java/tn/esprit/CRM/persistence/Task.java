package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	   
	@Id
	private Integer id_task;
	private String title;
	private String description_task;
	private Date start_date_task;
	private Date end_date_task;
	private String document;
	@Enumerated(EnumType.STRING)
	private Status_type status_task;
	@Enumerated(EnumType.STRING)
	private Priority_type priority;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task() {
		super();
	}   
	public Integer getId_task() {
		return this.id_task;
	}

	public void setId_task(Integer id_task) {
		this.id_task = id_task;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription_task() {
		return this.description_task;
	}

	public void setDescription_task(String description_task) {
		this.description_task = description_task;
	}   
	public Date getStart_date_task() {
		return this.start_date_task;
	}

	public void setStart_date_task(Date start_date_task) {
		this.start_date_task = start_date_task;
	}   
	public Date getEnd_date_task() {
		return this.end_date_task;
	}

	public void setEnd_date_task(Date end_date_task) {
		this.end_date_task = end_date_task;
	}   
	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}   
	
	
	public Status_type getStatus_task() {
		return status_task;
	}
	public void setStatus_task(Status_type status_task) {
		this.status_task = status_task;
	}
	public Priority_type getPriority() {
		return priority;
	}
	public void setPriority(Priority_type priority) {
		this.priority = priority;
	}
	
	
   
}
