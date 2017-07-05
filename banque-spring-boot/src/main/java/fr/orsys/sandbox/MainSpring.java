package fr.orsys.sandbox;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpring {

	public static void main(String[] args) {
		
		
		BeanFactory spring = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
		
		System.out.println("**** démarrage de l'appli *****");
		Client client = spring.getBean("client2", Client.class);
		Client client1 = spring.getBean("client2", Client.class);
		Client client3 = spring.getBean("client1", Client.class);
		Client client4 = spring.getBean("client1", Client.class);
		client.faireQQChose();
		System.out.println(client == client1); // prototype --> false
		System.out.println(client3 == client4); // singleton --> true

	}

}
