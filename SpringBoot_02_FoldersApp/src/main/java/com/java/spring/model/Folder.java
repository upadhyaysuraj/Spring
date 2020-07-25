package com.java.spring.model;

import java.util.Date;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Folder
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private Date dateCreated;
	private int totalFiles;
	@OneToMany
	private Map<String, MyFile> files;
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}
	
	public int getTotalFiles()
	{
		return totalFiles;
	}
	
	public void setTotalFiles(int totalFiles)
	{
		this.totalFiles = totalFiles;
	}
	
	public Map<String, MyFile> getFiles()
	{
		return files;
	}
	
	public void setFiles(Map<String, MyFile> files)
	{
		this.files = files;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
