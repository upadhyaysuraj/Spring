package com.java.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
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
			
			File dir = new File(folder.getFolderPath());
			dir.mkdirs();
			
			return true;
		}
		return false;
	}

	/*
	 * Just verify if it deletes all the files from the database as well!
	 */
	@Override
	public boolean deleteFolder(String folderName)
	{
		if(folderName == null || folderName.length() < 1) return false;
		
		Folder folder = folderDao.findFolder(folderName);		
		if(folder != null)
		{
			String folderPathToDelete = folder.getFolderPath();
			folder.deleteAllFiles();
			folderDao.delete(folder);
			
			return deleteLocalFolder(new File (folderPathToDelete));
		}
		return false;
	}
	
	private boolean deleteLocalFolder(File dir)
	{
		if(dir.isDirectory())
		{
			for(File file : dir.listFiles())
			{
				if(file.isDirectory())
				{
					return deleteLocalFolder(file);
				}
				file.delete();
			}
		}
		return (dir.delete());
	}
	
	@Override
	public boolean addFile(String folderName, MyFile file, byte[] content)
	{
		if(folderName != null && file != null)
		{
			Folder folder = folderDao.findFolder(folderName);

			if (folder != null && folder.addFile(file))
			{
				if (addFileToLocalStorage(folder.getFolderPath(), file.getName(), content))
				{
					folderDao.save(folder);
					return true;
				} 
				else
				{
					folder.deleteFile(file.getName());
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * - Creates a new directory if does not exists
	 * - returns false if the file already exists
	 * - else creates the file and writes to it
	 * - if all done successfully, only then, it returns true
	 * 
	 */
	private boolean addFileToLocalStorage(String folderPath, String fileName, byte[] content)
	{
		//Dir --> if not exists -> create one
		File dir = new File(folderPath);
		if(!dir.exists()) dir.mkdirs();
		
		//file --> if exists -> return false (can not add the file)
		File newFile = new File(dir, fileName);
		if(newFile.exists()) return false;
		
		//writing the bytes to the file
		OutputStream out = null;
		try
		{
			newFile.createNewFile();
			out = new FileOutputStream(newFile);
			out.write(content);
			
		} catch (IOException e)
		{
			//e.printStackTrace();
			return false;
		} finally 
		{
			if(out != null) 
			{
				try
				{
					out.close();
				} catch (IOException e)
				{
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Just verify if the diles are deleted from the db using cascading
	 * Try to comment out folderDoa.save(folder); 
	 * to see if it auto-saves it
	 */
	@Override
	public boolean deleteFile(String folderName, String fileName)
	{
		Folder folder = folderDao.findFolder(folderName);
		
		if(folder != null && folder.deleteFile(fileName))
		{
			folderDao.save(folder);
			File file = new File(folder.getFolderPath() + fileName);
			if(file.exists())
			{
				file.delete();
				return true;
			}
			
			//File deleted from the folder obj but it was not found in the directory
			return true;
		}
		return false;
	}

	@Override
	public MyFile getFileByName(String folderName, String fileName)
	{
		Folder folder = getFolderByName(folderName);
		
		if(folder != null)
		{
			return folder.getFileByName(fileName);
		}
		return null;
		
	}
	
	@Override
	public Set<MyFile> getAllFolderFiles(String folderName)
	{
		Folder folder = getFolderByName(folderName);
		if(folder != null)
		{
			return folder.getFiles();
		}
		return null;
	}
	
}
