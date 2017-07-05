package fr.orsys.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.entity.Compte;
import fr.orsys.entity.DebitNonAutoriseException;
import fr.orsys.service.Banque;
import fr.orsys.util.ApplicationContextProvider;


@RestController
@RequestMapping("rest/compte")
public class BanqueRestController {
	@Autowired
	Banque banque;
	
	@RequestMapping(value="", produces={MediaType.APPLICATION_XML_VALUE, 
	        MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Compte>> getCompteAll(Model model) {; 
		 // traitement métier ... et emission de la réponse http ...
		List<Compte> comptes = banque.getLesComptes();
		return new ResponseEntity<List<Compte>>(comptes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{numero}", produces={MediaType.APPLICATION_XML_VALUE, 
	        MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Compte> getCompte(@PathVariable Integer numero, Model model) {; 
		 // traitement métier ... et emission de la réponse http ...
		Compte cpt = banque.getCompte(numero);
		return new ResponseEntity<Compte>(cpt, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{numero}", method=RequestMethod.PUT, produces={MediaType.APPLICATION_XML_VALUE, 
	        MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Compte> executeOperation(@PathVariable Integer numero, @RequestParam Float montant, @RequestParam String operation) throws DebitNonAutoriseException {
		 // traitement métier ... et emission de la réponse http ...
		
		if(operation.equals("crediter"))banque.crediter(numero, montant);
		if(operation.equals("debiter"))banque.debiter(numero, montant);;
		return new ResponseEntity<Compte>(banque.getCompte(numero), HttpStatus.OK);
	}

}
