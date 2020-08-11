package com.java.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;


@Entity(name="File")
public class MyFile
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "fileName")
	private String name;
	@CreationTimestamp
	private Date dateAdded;
	private int parentFolder;
	
	public int getParentFolder()
	{
		return parentFolder;
	}

	public void setParentFolder(int parentFolder)
	{
		this.parentFolder = parentFolder;
	}

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

	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass() != MyFile.class) return false;
		
		MyFile temp = (MyFile) obj;
		return temp.getName().equalsIgnoreCase(name);
	}

	
	@Override
	public int hashCode()
	{
		return this.name.hashCode();
	}
	
}
