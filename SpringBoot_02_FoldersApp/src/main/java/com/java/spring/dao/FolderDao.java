package com.java.spring.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.spring.model.Folder;

@Repository
public interface FolderDao extends JpaRepository<Folder, Integer>
{
	List<Folder> findByName(String name);
	
	default Folder findFolder(String folderName)
	{
		List<Folder> folders = findByName(folderName);
		
		if(folders == null || folders.isEmpty()) 
			return null;
		return folders.get(0);
	}
}
