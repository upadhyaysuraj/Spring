package org.suraj.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suraj.model.Triangle;

public class SpringDemo 
{

	public static void main(String[] args) 
	{
		ApplicationContext myFactory = new ClassPathXmlApplicationContext("spring.xml");

		Triangle t1 = (Triangle) (myFactory.getBean("tri"));
		System.out.println(t1);
		
		Triangle t2 = (Triangle) (myFactory.getBean("tri-alias_1"));
		System.out.println(t2);
		
		Triangle t3 = (Triangle) (myFactory.getBean("tri-alias_2"));
		System.out.println(t3);
		
		
		((ClassPathXmlApplicationContext)myFactory).close();
	}
	

}