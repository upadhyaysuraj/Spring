package org.suraj.model;

import java.util.List;

public class TrianglePointList
{
	private List<Point> points;
	
	public TrianglePointList()
	{}

	public List<Point> getPoints()
	{
		return points;
	}

	public void setPoints(List<Point> points)
	{
		this.points = points;
	}

	@Override
	public String toString()
	{
		String str = "Tri: [";
		
		for(Point p : points)
		{
			str = str + p + ", ";
		}
		
		str = str.substring(0, str.length()-2) + "]";
		
		return str;
	}
}
