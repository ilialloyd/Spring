package com.company.springannotations;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

//	private FortuneService fortuneService;

//	public CricketCoach() {
//		System.out.println(">>inside default constractor");
//	}

	// Setting setter method injection
//	@Autowired  //Injecting dependencies by calling setter method
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> Inside CricketCoach: inside setFortuneService() method");
//		this.fortuneService=fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Hit the ball 5 times and run";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "It is your lucky day Michael";
	}

//	@Autowired //you can baasicly use @Autowired with any method. 
	// Warning INFO: Autowired annotation should only be used on methods with
	// parameters:
//	public void doSomeCrazyStuff() {
//		System.out.println("Doing some crazy stuff");
//	}

}
