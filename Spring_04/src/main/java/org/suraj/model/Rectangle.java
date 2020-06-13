package org.suraj.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("rec")
public class Rectangle implements Shape
{
	@Autowired
	private Point p1, p2, p3, p4;
	
	public Rectangle()
	{}

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

	public Point getP4()
	{
		return p4;
	}

	public void setP4(Point p4)
	{
		this.p4 = p4;
	}
	
	@Override
	public String toString()
	{
		String str = "Rec: [" + this.p1 + ", " + this.p2 + ", " + 
										this.p3 + ", " + this.p4 + "]";
		return str;
	}

	public void draw()
	{
		System.out.println("Rectangle: draw()");
	}
}
