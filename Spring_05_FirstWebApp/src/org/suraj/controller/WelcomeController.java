package org.suraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{

	@RequestMapping("/")
	public ModelAndView m()
	{
		ModelAndView mNv = new ModelAndView("welcome");
		mNv.addObject("username", "Suraj");
		return mNv;
	}
	
}
