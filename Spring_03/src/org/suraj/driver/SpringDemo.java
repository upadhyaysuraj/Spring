package org.suraj.driver;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suraj.model.Triangle;
import org.suraj.model.TrianglePointList;

public class SpringDemo 
{

	public static void main(String[] args) 
	{
		AbstractApplicationContext myFactory = new ClassPathXmlApplicationContext("spring.xml");
		myFactory.registerShutdownHook();
		
		Triangle t1 = (Triangle) (myFactory.getBean("tri"));
		System.out.println(t1);
		
		
		TrianglePointList t5 = (TrianglePointList) (myFactory.getBean("tri-point-list"));
		System.out.println(t5);

				
		((ClassPathXmlApplicationContext)myFactory).close();
	}
	

}
