package com.spring.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //extends component
public class HomeController {


	@RequestMapping("/")//linki veririk bu methoda sorgu ucun
	public String showPage() {
		return "main-menu";
	}

}
