package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Calendar
 *
 */
@Entity

public class Calendar implements Serializable {

	   
	@Id
	private Integer id_calendar;
	private String event_name;
	@Enumerated(EnumType.STRING)
	private Type_calendar type_event;
	private Date start_date;
	private Date end_date;
	private String place_event;
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="calendars")
	private List<User> users6;
	
	
	
	public List<User> getUsers6() {
		return users6;
	}
	public void setUsers6(List<User> users6) {
		this.users6 = users6;
	}
	public Calendar() {
		super();
	}   
	public Integer getId_calendar() {
		return this.id_calendar;
	}

	public void setId_calendar(Integer id_calendar) {
		this.id_calendar = id_calendar;
	}   
	public String getEvent_name() {
		return this.event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}   
	
	
	public Type_calendar getType_event() {
		return type_event;
	}
	public void setType_event(Type_calendar type_event) {
		this.type_event = type_event;
	}
	public Date getStart_date() {
		return this.start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}   
	public Date getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}   
	public String getPlace_event() {
		return this.place_event;
	}

	public void setPlace_event(String place_event) {
		this.place_event = place_event;
	}
   
}
