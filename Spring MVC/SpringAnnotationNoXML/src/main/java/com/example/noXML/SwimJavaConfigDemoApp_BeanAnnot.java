package com.example.noXML;

import com.example.noXML.coachIMPL.SwimCoach;
import com.example.noXML.config.SportConfig;
import com.example.noXML.interfaces.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp_BeanAnnot {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

	//retrieve from spring container
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);//public Coach swimCoach-daki swimCoach
		//Coach crazySwimCoach = context.getBean("crazySwimCoach", Coach.class);

		
		// call the method on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		System.out.println("Coach email: "+coach.getEmail());
		System.out.println("Coach name: "+coach.getName());



		// close the context
		context.close();

	}

}
