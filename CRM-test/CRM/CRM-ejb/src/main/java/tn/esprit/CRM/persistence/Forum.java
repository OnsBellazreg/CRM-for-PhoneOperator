package tn.esprit.CRM.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Forum
 *
 */
@Entity

public class Forum implements Serializable {

	   
	@Id
	private Integer id_forum;
	private String Object;
	private String Description;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="forums")
	private List<User> users;
	
	
	public Forum() {
		super();
	}  
	
	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Integer getId_forum() {
		return this.id_forum;
	}

	public void setId_forum(Integer id_forum) {
		this.id_forum = id_forum;
	}   
	public String getObject() {
		return this.Object;
	}

	public void setObject(String Object) {
		this.Object = Object;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
