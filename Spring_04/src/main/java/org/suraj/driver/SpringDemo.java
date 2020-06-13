package org.suraj.driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.suraj.model.Shape;
import org.suraj.model.Triangle;

public class SpringDemo 
{

	public static void main(String[] args) 
	{		
		AbstractApplicationContext myFactory = new AnnotationConfigApplicationContext("org.suraj.model");
		myFactory.registerShutdownHook();
		
		Shape shape = (Shape) (myFactory.getBean("triangle"));
		((Triangle)shape).getP1().setX(3);
		System.out.println(shape);
		shape.draw();
		
		shape = (Shape) (myFactory.getBean("rec"));
		System.out.println(shape);
		shape.draw();
		

				
		((AnnotationConfigApplicationContext)myFactory).close();
	}
	

}
