package fr.orsys.sandbox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("fr.orsys.sandbox")
@PropertySource(
        value={"classpath:spring/banque.properties"},
        ignoreResourceNotFound = true)
public class ConfigurationSpring {
//	@Autowired
//	Fournisseur f2;
	

	@Bean
	public Client client2(Fournisseur f2) {
		Client c = new Client("autreNom");
		c.setFournisseur(f2);
		return c;
	}
}
