package com.company.springdemo;

public class SoccerCoach implements Coach {

	
	private RandomFortuneService randomFortuneService ;
	
	
	
	
	
	public SoccerCoach() {
		super();
	}

	public SoccerCoach(RandomFortuneService randomFortuneService) {
		System.out.println("We are in SoccerCoach constructor ");

		this.randomFortuneService = randomFortuneService;
	}

	public void setRandomFortuneService(RandomFortuneService randomFortuneService) {
		System.out.println("We are in setRandomFortuneService method ");
		this.randomFortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Shoot 15 penalty";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return randomFortuneService.getFortune();
	}

}
