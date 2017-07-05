package fr.orsys.sandbox;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("f1")
@Primary
@Scope("singleton")
public class UnFournisseur implements Fournisseur {

	@Override
	public void rendreUnService() {
		System.out.println("je rends le service attendu par mon client ...");

	}
	
	public UnFournisseur() {
		System.out.println("instanciatoin d'un UnFournisseur");
		// TODO Auto-generated constructor stub
	}

}
