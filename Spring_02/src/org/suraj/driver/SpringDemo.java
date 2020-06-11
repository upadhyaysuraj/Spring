package org.suraj.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suraj.model.Point;
import org.suraj.model.Triangle;
import org.suraj.model.TrianglePointList;

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
		
		TrianglePointList t4 = (TrianglePointList) (myFactory.getBean("tri-point-list"));
		System.out.println(t4);
		t4.getPoints().set(0, new Point(5, 5));
		
		
		TrianglePointList t5 = (TrianglePointList) (myFactory.getBean("tri-point-list"));
		System.out.println(t5);

				
		((ClassPathXmlApplicationContext)myFactory).close();
	}
	

}
