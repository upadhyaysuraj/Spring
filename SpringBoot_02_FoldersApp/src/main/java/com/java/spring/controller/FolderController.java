package com.java.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;
import com.java.spring.service.FolderService;

@RestController
public class FolderController
{
	@Autowired
	private FolderService folderService;
	private final String StoragePath = "/Users/surajupadhyay/Sub/FILES/";
	
	@GetMapping("/")
	public List<Folder> getAllFolders()
	{
		return folderService.getAllFolders();
	}
	
	@PostMapping("/addFolder")
	public boolean addFolder(@ModelAttribute Folder folder)
	{
		folder.setFolderPath(StoragePath + folder.getName() + "/");
		return folderService.addFolder(folder);
	}
	
	@DeleteMapping("/deleteFolder")
	public boolean deleteFolder(@RequestParam String folderName)
	{
		return folderService.deleteFolder(folderName);
	}
	
	@PostMapping(value = "/{folderName}/addFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean addFile(@PathVariable String folderName,
			@ModelAttribute MyFile file, @RequestParam MultipartFile fileContent)
	{
		try
		{
			return folderService.addFile(folderName, file, fileContent.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@DeleteMapping("/{folderName}/deleteFile")
	public boolean deleteFile(@PathVariable String folderName, @RequestParam String fileName)
	{
		return folderService.deleteFile(folderName, fileName);
	}
	
	@GetMapping("/{folderName}")
	public Set<MyFile> getFolderFiles(@PathVariable String folderName)
	{
		return folderService.getAllFolderFiles(folderName);
	}
	
	@PostMapping("/{folderName}/getFile")
	public MyFile getFile(@PathVariable String folderName, @RequestParam String fileName)
	{
		return folderService.getFileByName(folderName, fileName);
	}
}
