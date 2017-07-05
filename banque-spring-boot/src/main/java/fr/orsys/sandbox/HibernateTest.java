package fr.orsys.sandbox;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.orsys.entity.Operation;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration()
				.configure("/hibernate/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Operation op = new Operation(100, Operation.CREDIT);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Long id = (Long)session.save(op);
		session.save(new Operation(100, Operation.DEBIT));
		System.out.println("Id de op=" + id);
		session.getTransaction().commit();
		session.close(); // ???
		
		session = sessionFactory.openSession();
		//session.beginTransaction();
		op = session.load(Operation.class, id);
		//session.getTransaction().commit();
		op.getId();
		session.close();
		
		System.out.println(op);
		
		session = sessionFactory.openSession();
		//session.beginTransaction();
		op = ((List<Operation>)session.createQuery("from Operation").list()).get(0);
		//session.getTransaction().commit();
		op.getId();
		session.close();
		
		System.out.println("**** suite uniqueResult ---> " + op);
		
		op.setType(Operation.DEBIT); // detached object ...
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(op);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(op);
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
		
		sessionFactory.close();

	}

}
