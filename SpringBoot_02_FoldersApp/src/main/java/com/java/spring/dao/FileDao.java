package com.java.spring.dao;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.spring.model.MyFile;

public interface FileDao extends JpaRepository<MyFile, Integer>
{
	MyFile findByFolderNameAndName(String folderName, String fileName);
	Set<MyFile> findByFolderName(String folderName);
}
