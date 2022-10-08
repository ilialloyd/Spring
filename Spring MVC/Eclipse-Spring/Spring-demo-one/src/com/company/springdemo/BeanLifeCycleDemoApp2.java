package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp2 {

	public static void main(String[] args) {

		// load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		
		
		//
		System.out.println(theCoach.getDailyWorkout());
	
	//close context
		context.close();
	}
	

}
