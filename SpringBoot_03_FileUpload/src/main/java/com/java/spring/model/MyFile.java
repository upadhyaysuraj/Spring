package com.java.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyFile
{
	@Id
	private String name;
	private String path;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
}
