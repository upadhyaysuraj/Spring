package org.suraj.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView m()
	{
		ModelAndView mNv = new ModelAndView("welcome");
		mNv.addObject("username", "Suraj");
		System.out.println("In m()");
		return mNv;
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ModelAndView path(@RequestParam Map<String, String> vars)
	{
		System.out.println("Request received!");
		ModelAndView mNv = new ModelAndView("welcome");
		//mNv.addObject("username", "Suraj");
		
		
		mNv.addObject("bookName", vars.get("bookName"));
		mNv.addObject("bookType", vars.get("bookType"));
		return mNv;
	}
}
