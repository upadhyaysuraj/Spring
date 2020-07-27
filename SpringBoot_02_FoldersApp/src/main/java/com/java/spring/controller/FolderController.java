package com.java.spring.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.java.spring.model.Folder;
import com.java.spring.model.MyFile;
import com.java.spring.service.FolderService;

@RestController
public class FolderController
{
	@Autowired
	private FolderService folderService;
	
	@GetMapping("/")
	public List<Folder> getAllFolders()
	{
		return folderService.getAllFolders();
	}
	
	@PostMapping("/addFolder")
	public boolean addFolder(@ModelAttribute Folder folder)
	{
		return folderService.addFolder(folder);
	}
	
	@PostMapping("/deleteFolder")
	public boolean deleteFolder(@RequestParam String folderName)
	{
		return folderService.deleteFolder(folderName);
	}
	
	@PostMapping("/{folderName}/addFile")
	public boolean addFile(@PathVariable String folderName,
			@ModelAttribute MyFile file)
	{
		return folderService.addFile(folderName, file);
	}
	
	@DeleteMapping("/{folderName}/deleteFile")
	public boolean deleteFile(@PathVariable String folderName, @RequestParam String fileName)
	{
		return folderService.deleteFile(folderName, fileName);
	}
	
	@GetMapping("/{folderName}")
	public Set<String> getFolderFiles(@PathVariable String folderName)
	{
		return folderService.getAllFiles(folderName);
	}
}
