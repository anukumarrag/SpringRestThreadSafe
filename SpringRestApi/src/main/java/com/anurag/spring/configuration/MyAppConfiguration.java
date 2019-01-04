package com.anurag.spring.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * {@link MyAppConfiguration}
 * @author anurag
 * 
 * This is a configuration class where declared for auto enable web MVC and Auto Spring component scan.
*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.anurag.spring")
public class MyAppConfiguration {

	public static SessionFactory sessionFactory;

	@Bean(name = "sessionFactory")
	public static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			synchronized (MyAppConfiguration.class) {
				if (sessionFactory == null) {

					org.hibernate.cfg.Configuration configObj = new org.hibernate.cfg.Configuration();
					configObj.configure("hibernate.cfg.xml");
					ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
							.applySettings(configObj.getProperties()).build();
					sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
				}

			}
		}

		return sessionFactory;
	}

}