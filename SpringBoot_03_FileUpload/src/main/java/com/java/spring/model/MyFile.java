package com.java.spring.model;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MyFile
{
	@Id
	private String name;
	@Lob
	private Blob file;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Blob getFile()
	{
		return file;
	}
	
	public void setFile(Blob file)
	{
		this.file = file;
	}
}
