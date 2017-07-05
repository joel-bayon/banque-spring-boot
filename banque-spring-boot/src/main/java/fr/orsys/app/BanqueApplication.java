package fr.orsys.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({fr.orsys.configuration.ConfigurationSpring.class,fr.orsys.web.WebConfiguration.class})
@ComponentScan("fr.orsys.controller")
@ServletComponentScan(basePackageClasses=fr.orsys.web.BanqueInitListener.class)
@EnableJpaRepositories(basePackages="fr.orsys.repository")

public class BanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}
}
