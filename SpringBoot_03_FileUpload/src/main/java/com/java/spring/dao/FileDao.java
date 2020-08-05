package com.java.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.model.MyFile;

public interface FileDao extends JpaRepository<MyFile, Integer>
{
	List<MyFile> findByName(String name);
	
	default MyFile findOneByName(String fileName)
	{
		List<MyFile> files = findByName(fileName);
		
		if(files != null && files.size() > 0)
		{
			return files.get(0);
		}
		return null;
	}
}
