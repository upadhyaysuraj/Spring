package com.java.spring.model;

public class Product
{
	private int PID;
	private String PNAME;
	private double PRICE;
	private int QTY;
	
	public Product()
	{}
	
	public int getPID()
	{
		return PID;
	}

	public void setPID(int pID)
	{
		PID = pID;
	}

	public String getPNAME()
	{
		return PNAME;
	}

	public void setPNAME(String pNAME)
	{
		PNAME = pNAME;
	}

	public double getPRICE()
	{
		return PRICE;
	}

	public void setPRICE(double pRICE)
	{
		PRICE = pRICE;
	}

	public int getQTY()
	{
		return QTY;
	}

	public void setQTY(int qTY)
	{
		QTY = qTY;
	}

	@Override
	public String toString()
	{
		String str = "";
		
		str += "ID: " + this.PID + ", Name: " + this.PNAME + 
				", Price: $" + this.PRICE + ", Quantity: " + this.QTY;
		
		return str;
	}
}
