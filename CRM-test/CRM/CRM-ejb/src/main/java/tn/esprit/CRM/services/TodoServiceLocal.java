package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.CRM.persistence.Todo;
import tn.esprit.CRM.persistence.User;

@Local
public interface TodoServiceLocal {
	
	void create(User user);
	List<Todo> findAll();

}
