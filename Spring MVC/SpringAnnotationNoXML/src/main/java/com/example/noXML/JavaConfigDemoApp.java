package com.example.noXML;

import com.example.noXML.config.SportConfig;
import com.example.noXML.interfaces.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

	//retrieve from spring container
		Coach coach = context.getBean("tennisCoach",Coach.class);

		
		// call the method on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		
		// close the context
		context.close();

	}

}
