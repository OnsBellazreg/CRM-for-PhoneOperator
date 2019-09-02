package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;


/**
 * Session Bean implementation class Staff
 */
@Stateless
@LocalBean

public class StaffService implements StaffServiceLocal,StaffServiceRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public StaffService() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void AjouterEmployee(Staff e) {
		entityManager.persist(e);
	}

	@Override
	public void SupprimerEmployee(User e) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(e));
		
	}

	@Override
	public void ModifierEmployee(Staff e) {
		// TODO Auto-generated method stub
		entityManager.merge(e);
		
	}

	@Override
	public List<Staff> AfficherEmployee() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT c FROM Staff c", Staff.class).getResultList();
	}

	@Override
	public User FindStaffById(Integer id_user) {
		return entityManager.find(Staff.class, id_user);
	}

	@Override
	public void AddDemandeConge(Conge conge) {
		entityManager.persist(conge);
		
	}

	@Override
	public void UpdateDemandeConge(Conge conge) {
		entityManager.merge(conge);
		
	}

	@Override
	public void DeleteDemandeConge(Conge conge) {
		entityManager.remove(entityManager.merge(conge));	
		
	}

	@Override
	public void UpdateStaff(Staff staff) {
		entityManager.merge(staff);
		
	}

	@Override
	public Conge FindDemandeCongeById(Integer id_co) {
		return entityManager.find(Conge.class, id_co);
	}

	@Override
	public Staff FindStaffByCin(Integer cin) {
		return entityManager.createQuery("select r from Staff r  where r.CIN="+cin,Staff.class).getSingleResult();
	}

	@Override
	public List<Conge> FindAllDemandeConge() {
		return entityManager.createQuery("SELECT c FROM Conge c ", Conge.class).getResultList();
	}

	@Override
	public List<Conge> FindDemandeCongeByCin(Integer cin) {
		return entityManager.createQuery("SELECT c FROM Conge c WHERE c.cin="+cin, Conge.class).getResultList();
	}

	@Override
	public List<Staff> FindAllStaff() {
		return entityManager.createQuery("SELECT c FROM Staff c ", Staff.class).getResultList();
	}

	@Override
	public void DeleteDemandeCongeByID(Integer id_co) {
		entityManager.createQuery("delete c from Conge c WHERE c.id_co="+id_co, Conge.class).executeUpdate();
		
	}
	@Override
	public List<User> FindAllUsers() {
		return entityManager.createQuery("SELECT c FROM User c ", User.class).getResultList();
	}
	@Override
	public User FindUserById(Integer id_co) {
		return entityManager.find(User.class, id_co);
	}
	@Override
	public List<Conge> FindDemandeCongeByStatus(String s) {
		return entityManager.createQuery("SELECT c FROM Conge c WHERE c.status_co="+s, Conge.class).getResultList();
	}

}
