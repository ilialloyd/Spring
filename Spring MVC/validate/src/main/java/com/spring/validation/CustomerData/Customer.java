package com.spring.validation.CustomerData;

import com.spring.validation.customAnnotationValidator.CourseCode;

import javax.validation.constraints.*;
//We will add validation rules to the field to make the textbox valid

public class Customer {

	@NotNull(message="Is Required") // it will display red error if required entered wrong
	@Size(min=2 , message=" Required")//it means text box cant be empty and it should get at least 1 character
	private String firstName;

	private String lastName;

	// adding validation rules
	@NotNull(message="Is Required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private Integer freePasses; //Because default value is String we use Integer to wrap String to int

	//regex exp.
@Pattern(regexp ="^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
private String postalCode;


	//here is if we have more than 1 valifdation rule
	@CourseCode(value = {"LUV","TOP"}, message = "must start TOP or LUV")
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}



}
