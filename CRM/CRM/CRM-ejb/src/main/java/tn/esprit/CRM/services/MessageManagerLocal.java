package tn.esprit.CRM.services;

import java.sql.Date;

import javax.ejb.Local;

import tn.esprit.CRM.persistence.Message;


@Local
public interface MessageManagerLocal {

	Message getFirstAfter(java.util.Date lastUpdate);

	void sendMessage(Message message);

	
 
}