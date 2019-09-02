package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.CRM.persistence.Todo;
import tn.esprit.CRM.persistence.User;

@Stateful
public class TodoService implements TodoServiceRemote, TodoServiceLocal {
	
	@PersistenceContext(unitName="CRM-ejb")
	private EntityManager em;

    public TodoService() {
    	
    }

	public void create(User user) {
		em.persist(user);
	}

	public List<Todo> findAll() {
		return em.createQuery("from Todo", Todo.class).getResultList();
	}

}
