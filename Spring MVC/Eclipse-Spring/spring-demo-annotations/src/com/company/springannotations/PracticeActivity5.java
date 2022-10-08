package com.company.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeActivity5 {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		JumpingCoach jcoach = context.getBean("jump",JumpingCoach.class);
		
		
		System.out.println(jcoach.getDailyWorkout());

		System.out.println(jcoach.getDailyFortune());
		
		
		context.close();

	}

}
