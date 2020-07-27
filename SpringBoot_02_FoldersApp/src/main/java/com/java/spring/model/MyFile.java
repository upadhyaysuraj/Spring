package com.java.spring.model;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity(name="File")
public class MyFile
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private Blob file;
	@CreationTimestamp
	private Date dateAdded;
	private String folderName;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Blob getFile()
	{
		return file;
	}
	
	public void setFile(Blob file)
	{
		this.file = file;
	}
	
	public Date getDateAdded()
	{
		return dateAdded;
	}
	
	public void setDateAdded(Date dateAdded)
	{
		this.dateAdded = dateAdded;
	}
	
	public String toString()
	{
		return this.name;
	}

	public String getFolderName()
	{
		return folderName;
	}

	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}
}
