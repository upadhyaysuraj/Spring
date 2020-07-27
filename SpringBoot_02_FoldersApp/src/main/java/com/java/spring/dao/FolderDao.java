package com.java.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.spring.model.Folder;

@Repository
public interface FolderDao extends JpaRepository<Folder, Integer>
{
	Folder findByName(String name);
}
