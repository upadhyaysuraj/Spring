package com.java.spring.config;


import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.java.spring")
@ComponentScan("com.java.spring")
@PropertySource("classpath:application.properties")
public class AppConfig
{
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dt()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	@Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      
      em.setDataSource(dt());
      em.setPackagesToScan(new String[] { "com.java.spring.model" });
      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      em.setJpaProperties(properties());
 
      return em;
   }
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	 
	    return transactionManager;
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties properties()
	{
		Properties p = new Properties();
//		p.setProperty("hibernate.hbm2ddl.auto", "update");
//		p.setProperty("hibernate.show_sql", "true");
//	   p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		return p;
	}
}
