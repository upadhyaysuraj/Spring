package org.suraj.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{
	
	@RequestMapping("/m")
	public ModelAndView m1()
	{
		ModelAndView mNv = new ModelAndView("welcome");
		mNv.addObject("username", "Upadhyay");
		System.out.println("In m1()");
		return mNv;
	}

	@RequestMapping("/")
	public ModelAndView m()
	{
		ModelAndView mNv = new ModelAndView("welcome");
		mNv.addObject("username", "Suraj");
		System.out.println("In m()");
		return mNv;
	}
	
	@RequestMapping("/{pathValue1}/{pathValue2}")
	public ModelAndView path(@PathVariable Map<String, String> vars)
	{
		ModelAndView mNv = new ModelAndView("welcome");
		mNv.addObject("username", "Suraj");
		mNv.addObject("pathValue1", vars.get("pathValue1"));
		mNv.addObject("pathValue2", vars.get("pathValue2"));
		return mNv;
	}
}
