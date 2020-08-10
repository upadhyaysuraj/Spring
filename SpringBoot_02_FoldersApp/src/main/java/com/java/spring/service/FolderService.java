package com.java.spring.service;

import java.util.List;
import java.util.Set;
import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;

public interface FolderService
{

	List<Folder> getAllFolders();

	Folder getFolderById(int folderId);
	
	boolean addFolder(Folder folder);
	
	boolean deleteFolder(String folderName);
	
	boolean addFile(String folderName, MyFile file, byte[] content);
	
	boolean deleteFile(String folderName, String fileName);
		
	MyFile getFileByName(String folderName, String fileName);

	Folder getFolderByName(String folderName);

	Set<MyFile> getAllFolderFiles(String folderName);
	
}
