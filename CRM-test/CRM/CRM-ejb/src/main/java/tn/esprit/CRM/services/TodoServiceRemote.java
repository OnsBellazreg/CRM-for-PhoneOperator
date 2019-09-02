package tn.esprit.CRM.services;

import javax.ejb.Remote;

import tn.esprit.CRM.persistence.User;

@Remote
public interface TodoServiceRemote {
	void create(User user);

}
