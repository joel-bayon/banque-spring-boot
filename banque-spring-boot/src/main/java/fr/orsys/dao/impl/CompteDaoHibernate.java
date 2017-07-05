package fr.orsys.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import fr.orsys.dao.CompteDao;
import fr.orsys.entity.Compte;
import fr.orsys.entity.CompteEpargne;
import fr.orsys.util.HibernateUtil;

public class CompteDaoHibernate implements CompteDao {

	@Override
	public Compte save(Compte entity) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		entity.setNumero((Integer)session.save(entity));
		return entity;
	} 

	@Override
	public Compte load(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return HibernateUtil.getCurrentSession().get(Compte.class, primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> LoadAll() {
		// TODO Auto-generated method stub
		return HibernateUtil.getCurrentSession()
				.createQuery("from Compte")
				.list();
	}

	@Override
	public void delete(Compte entity) {
		HibernateUtil.getCurrentSession().delete(entity);

	}

//	@Override
//	public void deleteAll(Collection<Compte> entities) {
//		entities.forEach(cpt -> delete(cpt));
//
//	}
	
	@Override
	public void deleteAll(Collection<Compte> entities) {
		for(Compte cpt : entities)
			delete(cpt);
	}

	@Override
	public void update(Compte entity) {
		HibernateUtil.getCurrentSession().update(entity);

	}

	@Override
	public List<CompteEpargne> loadCompteEpargneAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte loadCompteWithOperation(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> loadCompteOnlyAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
