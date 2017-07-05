package fr.orsys.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JpaUtil {
	static private final EntityManagerFactory emf;
	
	static private ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();

	static {
		emf = Persistence.createEntityManagerFactory("banque");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	static public EntityManager getCurrentEntityManager() {
		// return persistenceContext (EntityManager)attached to the current
		// thread ...

		EntityManager em = emThreadLocal.get();
		if (em == null) {
			em = emf.createEntityManager();
			emThreadLocal.set(em);
		}
		return em;
	}

	static public void closeCurrentEntityManager() {
		if (emThreadLocal.get() != null) {
			emThreadLocal.get().close();
			emThreadLocal.set(null);
		}
	}

}
