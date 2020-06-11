package org.suraj.trials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo 
{

	public static void main(String[] args) 
	{
		ApplicationContext myFactory = new ClassPathXmlApplicationContext("spring.xml");

		Triangle t1 = (Triangle) (myFactory.getBean("tri-def_const"));
		System.out.println(t1);
		
		Triangle t2 = (Triangle) (myFactory.getBean("tri-1_arg_const"));
		System.out.println(t2);
		
		Triangle t3 = (Triangle) (myFactory.getBean("tri-2_arg_const"));
		System.out.println(t3);
		
		/*
		threading(myFactory).start();
		threading(myFactory).start();
		*/
		
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
