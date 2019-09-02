package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.CRM.persistence.Conge;
import tn.esprit.CRM.persistence.Staff;
import tn.esprit.CRM.persistence.User;

@Remote
public interface StaffServiceRemote {

	public void AjouterEmployee(Staff e);
	public void SupprimerEmployee(User e);
	public void ModifierEmployee(Staff e);
	public List<Staff> AfficherEmployee();
	 public User FindStaffById(Integer id_user);
		void AddDemandeConge(Conge conge);

		void UpdateDemandeConge(Conge conge);

		void DeleteDemandeConge(Conge conge);

		void UpdateStaff(Staff staff);

		Conge FindDemandeCongeById(Integer id_co);

		Staff FindStaffByCin(Integer cin);
		public List<User> FindAllUsers();
		public User FindUserById(Integer id_co);

		List<Conge> FindAllDemandeConge();

		List<Conge> FindDemandeCongeByCin(Integer cin);

		List<Staff> FindAllStaff();

		void DeleteDemandeCongeByID(Integer id_co);
		public List<Conge> FindDemandeCongeByStatus(String s);
}
