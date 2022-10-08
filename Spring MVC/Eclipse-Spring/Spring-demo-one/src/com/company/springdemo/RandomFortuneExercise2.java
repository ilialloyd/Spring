package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFortuneExercise2 {
	public static void main(String[] args) {

		// loaded spring configration
		ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		SoccerCoach theCoach = xml.getBean("mySoccerCoach", SoccerCoach.class);

		// call our method for fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new method for daily workout
		System.out.println(theCoach.getDailyWorkout());

		// close
		xml.close();

	}

}
