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
		System.out.println("Triangle obj made using no-arg constructor!");
	}
	
	public Triangle(int x)
	{
		this.x = x; 
		this.y = 0;
		
		System.out.println("Triangle obj made using 1-arg constructor!");
	}
	
	public Triangle(int x, int y)
	{
		this.x = x; 
		this.y = y;
		
		System.out.println("Triangle obj made using 2-arg constructor!");
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
	
	@Override
	public String toString()
	{
		return "Tri: [x:" + this.x + ", y:" + this.y + "]";
	}
}
