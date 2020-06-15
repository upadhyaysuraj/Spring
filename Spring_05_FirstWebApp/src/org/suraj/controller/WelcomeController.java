package org.suraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/H")
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
}
