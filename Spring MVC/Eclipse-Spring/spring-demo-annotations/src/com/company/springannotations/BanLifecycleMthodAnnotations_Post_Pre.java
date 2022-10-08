package com.company.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BanLifecycleMthodAnnotations_Post_Pre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach coach = context.getBean("swimCoach", SwimCoach.class);
		


//print result
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		
		
		//close context
		context.close();
	}

}
