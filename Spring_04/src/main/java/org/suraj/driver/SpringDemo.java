package org.suraj.driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suraj.model.Triangle;

public class SpringDemo 
{

	public static void main(String[] args) 
	{		
		AbstractApplicationContext myFactory = new AnnotationConfigApplicationContext("org.suraj");
		myFactory.registerShutdownHook();
		
		Triangle t1 = (Triangle) (myFactory.getBean("tri"));
		System.out.println(t1);
		

				
		((AnnotationConfigApplicationContext)myFactory).close();
	}
	

}
