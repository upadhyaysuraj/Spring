package com.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.java.spring.dao")
public class SpringBoot02FoldersAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBoot02FoldersAppApplication.class, args);
	}

}
