package fr.orsys.sandbox;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("f2")
@Scope("prototype")
public class AutreFournisseur implements Fournisseur {

	@Override
	public void rendreUnService() {
		System.out.println("je rends mieux ... le service attendu par mon client ...");
	}
	
	public AutreFournisseur() {
		System.out.println("instanciatoin d'un AutreFournisseur");
		// TODO Auto-generated constructor stub
	}

}
