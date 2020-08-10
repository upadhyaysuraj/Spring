package com.java.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
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
	
	@PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean receiveFile(@RequestParam String name, 
			@RequestParam MultipartFile file) throws SerialException, SQLException, IOException
	{	
		File dir = ResourceUtils.getFile("src/main/resources/files");
		File newFile = new File(dir, name + ".png");
		newFile.createNewFile();
		
		      
		System.out.println("Dir Exists: " + dir.exists());
		System.out.println("Dir path: " + dir.getAbsolutePath());
		
		OutputStream out = new FileOutputStream(newFile);
		out.write(file.getBytes());
		out.close();		
		
		/*
		
		MyFile myFile = new MyFile();
		myFile.setName(name);
		myFile.setPath("/files/" + name);
		
		//myFile.setFile(new SerialBlob(file.getBytes()));
		myFile.setName(name);
		
		*/
		
		return true;
	}
	
	@GetMapping(value = "/{fileName}")
	public byte[] getFile(@PathVariable String fileName) throws IOException, SQLException
	{
		MyFile myFile = fileDao.findOneByName(fileName);
		
		if(myFile == null) return null;
		
		
		
		
		return null;
	}
	
}
