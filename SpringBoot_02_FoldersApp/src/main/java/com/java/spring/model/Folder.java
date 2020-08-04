package com.java.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Folder
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@CreationTimestamp
	private Date dateCreated;
	private int totalFiles;
	@ElementCollection
	private Set<String> files = new HashSet<String>();
	
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
	
	public Set<String> getFiles()
	{
		return files;
	}
	
	public void setFiles(Set<String> files)
	{
		this.files = files;
	}
	
	public boolean addFile(String fileName)
	{
		if(files.add(fileName))
		{
			totalFiles++;
			return true;
		}
		return false;
	}
	
	public boolean deleteFile(String fileName)
	{
		if(files.remove(fileName))
		{
			totalFiles--;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
