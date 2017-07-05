package fr.orsys.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import fr.orsys.service.Banque;


@WebListener
public class BanqueInitListener  implements ServletContextListener {
	@Autowired
	Banque banque;
	
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {	
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		banque.ouvrirCompte(10.0f);
		banque.ouvrirCompte(200.0f);
		banque.ouvrirCompte(3000.0f);
		banque.ouvrirCompteEpargne(4000.0f,0.2f);
		banque.ouvrirCompteEpargne(50000.0f,0.5f);
		
	}

}
