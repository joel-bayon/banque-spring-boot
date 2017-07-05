package fr.orsys.service;

import java.util.List;

import fr.orsys.entity.Compte;
import fr.orsys.entity.DebitNonAutoriseException;

public interface Banque {

	public List<Compte> getLesComptes();
	public int ouvrirCompte(float depotInitial);
	public int ouvrirCompteEpargne(float depotInitial, float taux);
	public Compte getCompte(int numero);
	public float fermerCompte(int numero);
	public void effectuerVirement(int idCpt1, float montant, int idCpt2) throws DebitNonAutoriseException;
	public void crediter(int idCompte, float montant);
	public void debiter(int idCompte, float montant) throws DebitNonAutoriseException;
}

