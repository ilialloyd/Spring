package com.company.springannotations.practise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.springannotations.Coach;

public class Practise4 {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		//get bean from spring container
		Coach coach = context.getBean("handballCoach",HandballCoach.class);
		
		//call method from the bean
		System.out.println(coach.getDailyWorkout());
		
		//close context
		context.close();
	}

}
