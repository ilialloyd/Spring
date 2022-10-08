package com.company.springdemo;

public class BaseballCoach implements Coach {
	
	
	public BaseballCoach() {
	}

	//defining private fiend for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for the dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	
	public String getDailyWorkout() {
		
		return "Spend 30 minutes on batting practise";
	}

	@Override
	public String getDailyFortune() {
		
		//use my fortuneService to get a fortune
		//dependency = helper
		return fortuneService.getFortune();
	}

}
