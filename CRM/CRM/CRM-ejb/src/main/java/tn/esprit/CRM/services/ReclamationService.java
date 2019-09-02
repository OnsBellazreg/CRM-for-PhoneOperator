package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.CRM.persistence.Reclamation;

@Stateless
@LocalBean
public class ReclamationService implements ReclamationServiceLocal,ReclamationServiceRemote{
	@PersistenceContext
	private EntityManager entityManager;

	public ReclamationService() {
	
	}

	@Override
	public void AjouterReclamation(Reclamation e) {
		entityManager.persist(e);
		
	}

	@Override
	public void SupprimerReclamation(Reclamation e) {
		entityManager.remove(entityManager.merge(e));
		
	}

	@Override
	public void ModifierReclamation(Reclamation e) {
		entityManager.merge(e);
		
	}

	@Override
	public List<Reclamation> AfficherReclamation() {
		return entityManager.createQuery("SELECT c FROM Reclamation c", Reclamation.class).getResultList();
	}

	
	@Override
	public void AjouterArchive(Reclamation e) {
		entityManager.persist(e);
		
	}


	
	

}
