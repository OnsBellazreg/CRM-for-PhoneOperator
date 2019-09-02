package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.CRM.persistence.Reclamation;



@Local
public interface ReclamationServiceLocal {

	public void AjouterReclamation(Reclamation e);
	public void SupprimerReclamation(Reclamation e);
	public void ModifierReclamation(Reclamation e);
	public List<Reclamation> AfficherReclamation();
	public void AjouterArchive(Reclamation e);
}
