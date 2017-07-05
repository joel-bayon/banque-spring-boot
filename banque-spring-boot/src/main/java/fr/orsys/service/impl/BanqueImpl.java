package fr.orsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.dao.CompteDao;
import fr.orsys.entity.Compte;
import fr.orsys.entity.CompteEpargne;
import fr.orsys.entity.DebitNonAutoriseException;
import fr.orsys.service.Banque;

//@Service
@Service
@Transactional
public class BanqueImpl implements Banque {
	
	private String nom;
	private String codeBanque;
	
	@Autowired
	CompteDao compteDao;
	
	
	@Autowired
	public BanqueImpl(@Value("${banque.nom}") String nom, @Value("${banque.codeBanque}") String codeBanque) {
		this.nom = nom;
		this.codeBanque = codeBanque;
	}

	@Override
	public List<Compte> getLesComptes() {
		return compteDao.LoadAll();
	}

	@Override
	public int ouvrirCompte(float depotInitial) {
		Compte cpt = new Compte(depotInitial);
		cpt = compteDao.save(cpt);
		return cpt.getNumero();
	}

	@Override
	public int ouvrirCompteEpargne(float depotInitial, float taux) {
		Compte cpt = new CompteEpargne(depotInitial, taux);
		cpt = compteDao.save(cpt);
		return cpt.getNumero();
	}

	@Override
	public Compte getCompte(int numero) {
		// TODO Auto-generated method stub
		return compteDao.load(numero);
	}

	@Override
	public float fermerCompte(int numero) {
		 Compte c = getCompte(numero);
		 if(c!=null && c.getSolde()>=0) {
			 compteDao.delete(c);
			 return c.getSolde();
		 }
		 System.out.println("fermeture impossible !");
		 return 0;
	}

	@Override
	public void effectuerVirement(int idCpt1, float montant, int idCpt2)
			throws DebitNonAutoriseException {
			Compte cptSource = getCompte(idCpt1);
			Compte cptDestination = getCompte(idCpt2);
			cptDestination.crediter(montant);
			cptSource.debiter(montant);
	}

	@Override
	public void crediter(int idCompte, float montant) {
		Compte cpt = getCompte(idCompte);
		cpt.crediter(montant);
	}

	@Override
	public void debiter(int idCompte, float montant)
			throws DebitNonAutoriseException {
		Compte cpt = getCompte(idCompte);
		cpt.debiter(montant);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(String codeBanque) {
		this.codeBanque = codeBanque;
	}
	
	

}
