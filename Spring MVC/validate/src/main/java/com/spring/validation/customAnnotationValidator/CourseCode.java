package com.spring.validation.customAnnotationValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//We will create custom annotation here and give some value 
//CourseCode will be our custom annotation


@Constraint(validatedBy = CourseCodeConstraintValidator.class)  //given class is Helper class that contains business rules/validation logic
@Target({ElementType.METHOD, ElementType.FIELD})  //can apply our annotation to a method or field
@Retention(RetentionPolicy.RUNTIME)// how long will the market annotation be stored or used //retain this annotation in the Java class and preocess it at runtime

public @interface CourseCode {
	
	//   This is the annotation default we want to create
	//   @CourseCode(value="LUV" , message="must start with LUV") 
	
	//define default course code---
	
	//we create value parameter and give default value if you dont add new val when define, it will get this default value
	//public String value() default "LUV";
	public String[] value() default {"LUV"};//array keys it means we can add few more validations rules
	
	//define default error message
	public String message() default "must start with LUV";
	
	
	//define default groups --you can group related validation constraints(kIsıtlama,sınırlama) 
	public Class<?>[]groups() default{};
	
	
	
	//define default payloads --provides addtitional/custom information about the validation error(severity level, error code etc)
	public Class<? extends Payload>[] payload() default{};

}
