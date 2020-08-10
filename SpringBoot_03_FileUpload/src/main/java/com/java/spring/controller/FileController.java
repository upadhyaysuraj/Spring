package com.java.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.dao.FileDao;
import com.java.spring.model.MyFile;

@RestController
public class FileController
{
	@Autowired
	private FileDao fileDao;
	private final String FOLDER_TO_UPLOAD = "/****/****/*****/***/";
	
	@PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean receiveFile(@RequestParam String name, 
			@RequestParam MultipartFile file)
	{	
		MyFile temp = fileDao.findOneByName(name);
		if(temp != null) return false;
		
		
		File dir = new File(FOLDER_TO_UPLOAD);
		dir.mkdir();
		File newFile = new File(dir, name);
		
		OutputStream out = null;
		try
		{
			newFile.createNewFile();
			out = new FileOutputStream(newFile);
			out.write(file.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(out != null)
			{
				try
				{
					out.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	
		
		
		MyFile myFile = new MyFile();
		myFile.setName(name);
		myFile.setPath(FOLDER_TO_UPLOAD + name);
		
		fileDao.save(myFile);
				
		
		return true;
	}
	
	@GetMapping(value = "/{fileName}")
	public String getFile(@PathVariable String fileName) throws IOException, SQLException
	{
		MyFile myFile = fileDao.findOneByName(fileName);
		
		if(myFile == null) return null;
		
		return myFile.getPath();
	}
	
}
