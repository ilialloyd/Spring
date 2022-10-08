package com.company.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		//Coach theCoach = context.getBean("taekwandoCoach", TaekwandoCoach.class);
//		Coach coach = context.getBean("cricketCoach", CricketCoach.class);
//		CricketCoach cricket = context.getBean("cricketCoach", CricketCoach.class);
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);

		// if you don't define variable, by default you will get class name
		// with lower case letter
		// Coach theCoach = context.getBean("tennisCoach",TennisCoach.class)

		// call the method on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// call our new swim coach methods ... has the props values injected
				System.out.println("email: " + coach.getEmail());
				System.out.println("team: " + coach.getTeam());
		
		// call the CricketCoach methods on the bean
	//	cricket.doSomeCrazyStuff();j
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
