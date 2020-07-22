package com.java.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass
{
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome";
	}
	
	@GetMapping("/{name}")
	public String hello(@PathVariable String name)
	{
		return "Hello! " + name;
	}
}
