package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Power of  Factory Pattern
		//if you want to call class, just change class name from the xml file
		
		
		// load the spring configuration(which edited xml file) file    -- created spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		                                 //bean id | interface
		TrackCoach theCoach = context.getBean("myCoach", TrackCoach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		
		//call our new method for fortune
		
	System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
		

	}

}
