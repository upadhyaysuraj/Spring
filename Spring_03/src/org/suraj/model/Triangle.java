package org.suraj.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, InitializingBean, DisposableBean
{
	private Point p1, p2, p3;
	private ApplicationContext context;
	
	static
	{
		System.out.println("Triangle class is loaded!");
	}
	
	public Triangle()
	{
		System.out.println("Triangle's default const. called to make a default obj.");
	}

	public Triangle(Point p1, Point p2, Point p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Point getP1()
	{
		return p1;
	}

	public void setP1(Point p1)
	{
		this.p1 = p1;
	}

	public Point getP2()
	{
		return p2;
	}

	public void setP2(Point p2)
	{
		this.p2 = p2;
	}

	public Point getP3()
	{
		return p3;
	}

	public void setP3(Point p3)
	{
		this.p3 = p3;
	}
	
	@Override
	public String toString()
	{
		String str = "Tri: [" + this.p1 + ", " + this.p2 + ", " + this.p3 + "]";
		
		return str;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		System.out.println("application context set!");
		this.context = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("Triangle object's props are set!");
	}

	@Override
	public void destroy() throws Exception
	{
		System.out.println("Triangle object is being destroyed!");
	}
}
