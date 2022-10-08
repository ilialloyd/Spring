package com.company.student.controller;

import com.company.student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestParam and @ModelAttribute https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/5653316#questions/4040502
//https://stackoverflow.com/questions/29370581/spring-mvc-please-explain-difference-between-requestparam-and-modelattribute

@Controller
@RequestMapping("/student") // that class level map means I should go /student/showform
//because we have many /showForm paths
public class StudentController {

	// injecting data from CountryDataSource
//@Autowired
//CountryDataSource countryOptions;
	// create method that showing the form

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		// create new student object
		Student theStudent = new Student();

		// add that student object as a model attribute
		model.addAttribute("student", theStudent);
		
		//model.addAttribute("countryOptions", theStudent);

		return "student-form"; // this is the adress of jsp file
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("bstudent") Student aStudent) {

		// log the input data. to make sure we have get the data
		System.out.println(
				"theStudent: " + aStudent.getFirstName() + " " + aStudent.getLastName() + " " + aStudent.getSelectedCountryValue()+" "+aStudent.getFavoriteLanguage());

		return "student-confirmation";

	}

}
