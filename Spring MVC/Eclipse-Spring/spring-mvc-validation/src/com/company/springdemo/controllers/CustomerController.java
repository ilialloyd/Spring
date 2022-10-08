package com.company.springdemo.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.springdemo.customer.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	
	
	//add an initbinder... to convert or trim input strings
	//remove leading and trailing whitespace
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("fillForm")
	public String fillForm(Model model) {

		model.addAttribute("customerAtt", new Customer());// birdasha define elemeden new student i gonderirik
		return "customer-form";

	}

	//Because freepAsses also one of customer field we dont need to add anything. it will handle all the fields
	@RequestMapping("processForm")
	public String processForm(
			@Valid @ModelAttribute("customerAtt") Customer theCustomer, // @Valid apply and perform validation rules on customer object
			BindingResult bindingResult) { // Result of valudation placed in the BindingResult
		
		// Important!!! BindingResult always should come after valid,model annotated
		// object instance
		
		//this give us many info to debug out error
		System.out.println("Binding result: "+bindingResult);
		System.out.println();
		//debug
		System.out.println("Customer info: |" + theCustomer.getFirstName()+"|"+theCustomer.getLastName()+"|"+
		"Free Passes: "+theCustomer.getFreePasses()+"|"+"Postal Code: "+theCustomer.getPostalCode()+
		"|"+"Course Code: "+theCustomer.getCourseCode()+"|\n\n\n");

		if (bindingResult.hasErrors()) {
			
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}

}
