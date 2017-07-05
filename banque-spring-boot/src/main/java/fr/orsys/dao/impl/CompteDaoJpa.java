package fr.orsys.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.dao.CompteDao;
import fr.orsys.entity.Compte;
import fr.orsys.entity.CompteEpargne;
import fr.orsys.util.HibernateUtil;
import fr.orsys.util.JpaUtil;


//@Repository
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CompteDaoJpa implements CompteDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Compte save(Compte entity) {
		// TODO Auto-generated method stub
		//EntityManager em = JpaUtil.getCurrentEntityManager();
		em.persist(entity);
		return entity;
	}

	@Override
	public Compte load(Serializable primaryKey) {
		// TODO Auto-generated method stub
		//EntityManager em = JpaUtil.getCurrentEntityManager();
		return em.find(Compte.class, primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> LoadAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Compte c")
				.getResultList();
	}

	@Override
	public void delete(Compte entity) {
		em.remove(entity);

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
		em.merge(entity);

	}

	@Override
	public List<CompteEpargne> loadCompteEpargneAll() {
		// TODO Auto-generated method stub
		return em
				.createQuery("select e from CompteEpargne e", CompteEpargne.class)
				.getResultList();
	}

	@Override
	public Compte loadCompteWithOperation(Serializable primaryKey) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select c from Compte c join fetch c.lesOperations where c.numero=:numero", Compte.class)
				.setParameter("numero", primaryKey) 
				.getSingleResult();
	} 

	@Override
	public List<Compte> loadCompteOnlyAll() {
		// TODO Auto-generated method stub
		return em
				.createQuery("select e from Compte e where e.class=Compte", Compte.class)
				.getResultList();
	}

}
