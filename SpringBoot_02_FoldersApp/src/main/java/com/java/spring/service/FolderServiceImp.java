package com.java.spring.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.spring.dao.FolderDao;
import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;

@Service
public class FolderServiceImp implements FolderService
{
	@Autowired
	private FolderDao folderDao;

	@Override
	public Collection<MyFile> getAllFiles(String folderName)
	{
		Folder folder = folderDao.findByName(folderName);
		
		if(folder != null)
		{
			return folder.getFiles().values();
		}
		
		return null;
	}

	@Override
	public Collection<Folder> getAllFolders()
	{
		return folderDao.findAll();		
	}

	@Override
	public Folder getFolderById(int folderId)
	{
		return folderDao.findById(folderId).orElse(null);
	}

	@Override
	public boolean addFolder(Folder folder)
	{
		if(folder != null && folderDao.findByName(folder.getName()) == null)
		{
			folderDao.save(folder);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFolder(Folder folder)
	{
		if(folder != null && folderDao.findByName(folder.getName()) != null)
		{
			folderDao.delete(folder);
			return true;
		}
		return false;
	}

	@Override
	public boolean addFile(Folder folder, MyFile file)
	{
		if(folder != null && file != null)
		{
			Folder temp = getFolderById(folder.getId());
			if(temp != null)
			{
				
			}
		}
		return false;
	}

	@Override
	public boolean deleteFile(Folder folder, MyFile file)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MyFile getFileById(Folder folder, int fileId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFile getFileByName(Folder folder, int fileName)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
