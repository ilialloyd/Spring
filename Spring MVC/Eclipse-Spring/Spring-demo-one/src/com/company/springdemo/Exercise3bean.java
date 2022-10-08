package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise3bean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load Spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanExercise3.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", ChessCoach.class);
		
		Coach coach = context.getBean("myCoach", ChessCoach.class);
		
		
		boolean result = (theCoach==coach);

		// print boolean
		
		System.out.println("Is t objext referances are same: "+result);
		
		//printing  memory location of each
				System.out.println("\nMemory location for theCoach: "+theCoach);
				
				System.out.println("\nMemory location for alphaCoach: "+coach);
		
		
				System.out.println(theCoach.getDailyWorkout());

		// close
		context.close();
	}

}
