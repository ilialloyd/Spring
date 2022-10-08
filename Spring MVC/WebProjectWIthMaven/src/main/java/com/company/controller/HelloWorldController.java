package com.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



//if you try to use 2 exact paths you may get this error.
//java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'sillyController' method 
//com.company.springdemo.mvc.SillyController#displayTheForm()
//to { [/showform]}: There is already 'helloWorldController' bean method

//in this case, we can use @Controller level RequestMapping
//instead of http://localhost:8080/showform
//http://localhost:8080/silly/showform

//to prevent this I will add @Controller level mapping

@Controller
@RequestMapping("/hello") //But now I need to change jsp file as well (main-menu)
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm") //defining the link for method for spring
	public String showForm() {
		return "helloworld-form"; //this is the appropriate .jsp file name
	}
	
	
	
	@RequestMapping("pro cessForm")
	public String processForm() {
		return "greeting";
	}
	
	
	
	//new a controller method to read form data and
	//add data to the model
	@RequestMapping("processFormVersion2")
	public String letsShoutTheName(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML file
		String theName = request.getParameter("studentName");
		String lastname = request.getParameter("studentLastname");
		
		//convert data to uppercase
		theName = theName.toUpperCase();
		lastname = lastname.toUpperCase();

		//create the massage
		String result = "HEY "+ theName+" "+lastname;
		
		//add massage to the model
		model.addAttribute("message", result);
		
		return "greeting";
	}
		
		/*
		 *  How to get More data 
		 *String result = .....
		 *List<Student> theStudentList = ...
		 *Teacher teacher = ...
		 *
		 *  how to add to the model
		 *  
		 * 	model.addAttribute("message", result);
		 * 
		 * 	model.addAttribute("students", theStudentList);
		 * 
		 * 	model.addAttribute("teacher", teacher);
		 *   
		 */
		
	

	@RequestMapping("/processFormVersion3")
	public String processVersion3(@RequestParam("studentName" )String theName,@RequestParam("studentLastname")String lastname, // @RequestParam - instead of "HttpServletRequest request"
			Model model) {
	
		
		//convert data to uppercase
		theName = theName.toUpperCase();
		lastname = lastname.toUpperCase();

		//create the massage
		String result = "Welcome to course our new student "+ theName+" "+lastname;
		
		//add massage to the model
		model.addAttribute("message", result);
		
		return "greeting";
	}
	
	
	

}
