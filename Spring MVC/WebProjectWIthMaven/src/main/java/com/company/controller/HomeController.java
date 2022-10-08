package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //extends component
public class HomeController {
	
	
	@RequestMapping("/")//linki veririk bu methoda sorgu ucun
	public String showPage() {
		System.out.println("In am inside Controller");
		return "main-menu";
	}
	
}
