package fr.orsys.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("client1")
@Scope("singleton")
@Primary
public class Client {
	@Value("${client.nom: inconnu}")String nom;
	
	@Autowired
	Fournisseur fournisseur;
	
	public Client(String nom) {
		this.nom = nom;
		System.out.println("instanciatoin d'un Client");
	}
	public Client() {
		System.out.println("instanciatoin d'un Client");
	}
	
	public void faireQQChose() {
		System.out.println("je me nomme : " + nom);
		fournisseur.rendreUnService();
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
