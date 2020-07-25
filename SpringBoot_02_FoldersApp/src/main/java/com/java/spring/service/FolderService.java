package com.java.spring.service;

import java.util.Collection;

import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;

public interface FolderService
{
	
	Collection<MyFile> getAllFiles(String folderName);

	Collection<Folder> getAllFolders();

	Folder getFolderById(int folderId);
	
	boolean addFolder(Folder folder);
	
	boolean deleteFolder(Folder folder);
	
	boolean addFile(Folder folder, MyFile file);
	
	boolean deleteFile(Folder folder, MyFile file);
	
	MyFile getFileById(Folder folder, int fileId);
	
	MyFile getFileByName(Folder folder, int fileName);
	

}
