package tn.esprit.CRM.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.CRM.persistence.Reclamation;


@Remote
public interface ReclamationServiceRemote {

	public void AjouterReclamation(Reclamation e);
	public void SupprimerReclamation(Reclamation e);
	public void ModifierReclamation(Reclamation e);
	public List<Reclamation> AfficherReclamation();
	public void AjouterArchive(Reclamation e);
}
