package com.java.spring.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.spring.dao.FileDao;
import com.java.spring.dao.FolderDao;
import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;

@Service
public class FolderServiceImp implements FolderService
{
	@Autowired
	private FolderDao folderDao;
	@Autowired
	private FileDao fileDao;

	@Override
 	public Set<String> getAllFiles(String folderName)
	{
		Folder folder = folderDao.findFolder(folderName);

		if(folder != null) 
			return folder.getFiles();
		
		return null;
	}

	@Override
	public List<Folder> getAllFolders()
	{
		return folderDao.findAll();		
	}

	@Override
	public Folder getFolderById(int folderId)
	{
		return folderDao.findById(folderId).orElse(null);
	}
	
	@Override
	public Folder getFolderByName(String folderName)
	{
		return folderDao.findFolder(folderName);		
	}

	@Override
	public boolean addFolder(Folder folder)
	{
		if(folder != null && folderDao.findFolder(folder.getName()) == null)
		{
			folderDao.save(folder);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFolder(String folderName)
	{
		if(folderName == null) return false;
		
		Folder folder = folderDao.findFolder(folderName);		
		if(folder != null)
		{
			for(MyFile file : fileDao.findByFolderName(folderName))
			{
				fileDao.delete(file);
			}
			
			folderDao.delete(folder);
			return true;
		}
		return false;
	}

	@Override
	public boolean addFile(String folderName, MyFile file)
	{
		if(folderName != null && file != null)
		{
			Folder folder = folderDao.findFolder(folderName);

			if(folder != null)
			{
				file.setFolderName(folderName);				
				if(folder.addFile(file.getName()))
				{
					folderDao.save(folder);
					fileDao.save(file);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteFile(String folderName, String fileName)
	{
		MyFile file = fileDao.findByFolderNameAndName(folderName, fileName);
		if(file != null)
		{
			fileDao.delete(file);
			folderDao.save(folderDao.findFolder(folderName));
			return true;
		}
		return false;
	}

	@Override
	public MyFile getFileByName(String folderName, String fileName)
	{
		return fileDao.findByFolderNameAndName(folderName, fileName);
	}
	
	@Override
	public Set<MyFile> getAllFolderFiles(String folderName)
	{
		return fileDao.findByFolderName(folderName);
	}
	
}
