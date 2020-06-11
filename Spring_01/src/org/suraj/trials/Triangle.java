package org.suraj.trials;

public class Triangle 
{
	private int x;
	private int y;
	
	static
	{
		System.out.println("Triangle class loaded!");
	}
	
	public Triangle()
	{
		System.out.println("Triangle obj made!");
	}
	
	public void draw()
	{
		System.out.println("Triangle is drawn!!");
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}
