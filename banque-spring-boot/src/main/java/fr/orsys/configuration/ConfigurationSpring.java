package fr.orsys.configuration;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:spring/spring.aop.xml")
@ComponentScan("fr.orsys.dao,fr.orsys.service,fr.orsys.aop, fr.orsys.util ")
@PropertySource(
        value={"classpath:spring/banque.properties"},
        ignoreResourceNotFound = true)
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ConfigurationSpring {
	
//    <bean id="entityManagerFactory"   
// 	  class="org.springframework...LocalEntityManagerFactoryBean">
//    			<property name="persistenceUnitName" 
//					 value="jpa_stand_alone"/>
//    </bean>
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("banque");
		return emf;
	}
    
    
//    <bean id="transactionManager" 	   
//	   class="org.springframework.orm.jpa.JpaTransactionManager">
//		<property name="entityManagerFactory" 
//				     ref="entityManagerFactory"/>
//    </bean>

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(entityManagerFactory);
		return txm;
	}
	
	/*<!-- bean post-processor for JPA annotations if needed -->
	<bean class="org...PersistenceAnnotationBeanPostProcessor"/>*/
	
/*	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		PersistenceAnnotationBeanPostProcessor pab =  new PersistenceAnnotationBeanPostProcessor();
		pab.setDefaultPersistenceUnitName("banque");
		return pab;
	}*/
	

	
	
}
