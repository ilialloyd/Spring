package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		
		Coach alphaCoach = context.getBean("myCoach", TrackCoach.class);
		
		
		//check if they are the same
		boolean result = (theCoach==alphaCoach);


		//printing the result
		System.out.println("\nPointing to the same object: "+result);
		
		//printing  memory location of each
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);

		
		// call the method
//		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theCoach.getDailyFortune());
	
	//close context
		context.close();
	}
	

}
