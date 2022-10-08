package com.spring.validation.customAnnotationValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//given class is Helper class that contains business rules/validation logic
//class has to implement ConstraintValidator
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	// assign the value passed in from our annotation
//	private String coursePrefix;
	private String[] coursePrefixes;

	// when you need to override methods, do from source,
	// because if you do quick fix, it will not show some default methods
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefixes = theCourseCode.value(); // .value() accesses the attribute value for that given annotation
	}

	/*
	 * Spring MVC will call isValid to see if something is valid?
	 * 
	 * theCode - that is the actual text from HTML Form Data that the user entered
	 * 
	 * theConstraintValidatorContext - constraint validator context - you can place
	 * additional error message here
	 * 
	 * in this isValid method you can do many other things: talk to database, call a
	 * web service, or restAPI, anything
	 */
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		/*
		 * this one is normal String version
		 * 
		 * Validation logic : Test if the form data starts with out course prefix - does
		 * it start with "LUV"
		 * 
		 * 
		 * Warning - always check first null version otherways you can get exceptions
		 * this is bad example. Because if I get no data, it will throw rexception
		 * 
		 * boolean result = theCode.startsWith(coursePrefix);
		 * 
		 * so in below we say
		 * 
		 * If code from user is null, validdate the pass,
		 * 
		 * If data from user not null, then check if it start with LUV if yes,
		 * 
		 * flag true else false and ask again and display "error" message
		 * 
		 * 
		 * boolean result; if(theCode!=null) result=theCode.startsWith(coursePrefix);
		 * else { result=true; }
		 * 
		 * return result; }
		 */

		// here is String[] array version
		// that means multipole validations string
		boolean result = false;
		if (theCode != null) {
			//
			// loop thru course prefixes
			//
			// check to see if code matches any of the course prefixes
			//
			for (String tempPrefix : coursePrefixes) {
				result = theCode.startsWith(tempPrefix);
				// if we found a match then break out of the loop
				if (result) {
					break;
				}
			}

		} else {
			result = true;
		}
		return result;
	}
}
