package org.suraj.trials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo 
{

	public static void main(String[] args) 
	{
		ApplicationContext myFactory = new ClassPathXmlApplicationContext("spring.xml");

		Triangle t = (Triangle) (myFactory.getBean("tri"));
		t.draw();
		t.setX(400);
		System.out.println(t.getX());
		
		
		threading(myFactory).start();
		threading(myFactory).start();
		
		
		((ClassPathXmlApplicationContext)myFactory).close();
	}
	
	public static Thread threading(ApplicationContext myFactory)
	{
		Thread th1 = new Thread( () -> 
		{
			Triangle tr1 = (Triangle) (myFactory.getBean("tri"));
			System.out.println(tr1.getX());
			
		});
		
		return th1;
	}

}
