package com.java.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Folder
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String folderPath;
	@CreationTimestamp
	private Date dateCreated;
	private int totalFiles;
	@OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL)
	private Set<MyFile> files = new HashSet<MyFile>();
	
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
	
	public Set<MyFile> getFiles()
	{
		return files;
	}
	
	public void setFiles(Set<MyFile> files)
	{
		this.files = files;
	}
	
	public MyFile getFileByName(String fileName)
	{
		for (MyFile file : files)
		{
			if(file.getName().equalsIgnoreCase(fileName)) return file;
		}
		return null;
	}
	
	/*
	 * using MyFile equals() and hashcode() method
	 * to check if the file exists or not
	 * in order to add the file
	 * 
	 * 
	 * Just need to make sure
	 * 
	 */
	public boolean addFile(MyFile file)
	{
		if(files.add(file))
		{
			totalFiles++;
			return true;
		}
		return false;
	}
	
	public boolean deleteFile(String fileName)
	{
		MyFile file = getFileByName(fileName);
		
		if(file != null && files.remove(file))
		{	
			totalFiles--;
			return true;
		}
		return false;
	}
	
	public boolean deleteAllFiles()
	{
		this.files.clear();
		return true;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public String getFolderPath()
	{
		return folderPath;
	}

	public void setFolderPath(String folderPath)
	{
		this.folderPath = folderPath;
	}
}
