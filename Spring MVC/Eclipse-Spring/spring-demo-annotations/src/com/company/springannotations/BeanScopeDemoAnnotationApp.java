package com.company.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//Because default scope is singleton ou get output same if you dont define scope

public class BeanScopeDemoAnnotationApp {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

//check if the are same
		boolean result = (coach == alphaCoach);

//print result
		System.out.println("Are objects same: " + result);

		System.out.println("Memory location of the coach: " + coach);

		System.out.println("Memory location of the coach: " + alphaCoach);
		
		
		//close context
		context.close();
	}

}

