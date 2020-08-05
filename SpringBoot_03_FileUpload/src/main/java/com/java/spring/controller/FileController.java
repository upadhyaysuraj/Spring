package com.java.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
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
	
	@PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean receiveFile(@RequestParam String name, 
			@RequestParam MultipartFile file) throws SerialException, SQLException, IOException
	{
		MyFile myFile = new MyFile();
		myFile.setFile(new SerialBlob(file.getBytes()));
		myFile.setName(name);
		
		return (fileDao.save(myFile) != null) ;
	}
	
	@GetMapping(value = "/{fileName}")
	public byte[] getFile(@PathVariable String fileName) throws IOException, SQLException
	{
		MyFile myFile = fileDao.findOneByName(fileName);
		
		if(myFile == null) return null;
		
		
		System.out.println("File to send: " + myFile.getFile());
		
		
		return myFile.getFile().getBinaryStream().readAllBytes();
	}
	
}
