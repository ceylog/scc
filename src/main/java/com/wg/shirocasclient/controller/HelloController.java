package com.wg.shirocasclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value="/hello")
	public String hello(Model model){
		model.addAttribute("arg", "hello");
		return "hello";
	}
	
	@RequestMapping("/shiro-cas")
	public String shiroCAS(Model model){
		model.addAttribute("arg","shiro-cas");
		return "hello";
	}
}
