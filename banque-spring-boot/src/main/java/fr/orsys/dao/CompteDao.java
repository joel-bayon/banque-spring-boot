package fr.orsys.dao;

import java.io.Serializable;
import java.util.List;

import fr.orsys.entity.Compte;
import fr.orsys.entity.CompteEpargne;

public interface CompteDao extends Dao<Compte> { 
	// + de méthode si nécessaire ...
	public List<CompteEpargne> loadCompteEpargneAll();
	public Compte loadCompteWithOperation(Serializable primaryKey);
	public List<Compte> loadCompteOnlyAll();
}
