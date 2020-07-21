package com.java.spring.config;


import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
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
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() 
	{
      LocalContainerEntityManagerFactoryBean em 
        = new LocalContainerEntityManagerFactoryBean();
      
      em.setDataSource(dt());
      em.setPackagesToScan(new String[] { "com.java.spring.model" });
      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      em.setJpaProperties(properties());
 
      return em;
   }
	
	@Bean(initMethod="start",destroyMethod="stop")
	public Server h2WebConsonleServer () throws SQLException 
	{
		Server s = Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
		return s;
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
		p.setProperty("hibernate.hbm2ddl.auto", "create");
		p.setProperty("hibernate.show_sql", "true");
	   p.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return p;
	}
}
