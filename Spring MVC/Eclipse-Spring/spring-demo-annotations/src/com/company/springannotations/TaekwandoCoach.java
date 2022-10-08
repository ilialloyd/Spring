package com.company.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TaekwandoCoach implements Coach {

	FortuneService fortuneService;

	public TaekwandoCoach() {
		System.out.println(">> TaekwandoCoach: inside default constructor");

	}

	@Autowired
	public TaekwandoCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		System.out.println(">> TaekwandoCoach: inside constructor using @autowired and @qualifier");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Stay one leg for 10 min. Change your leg in every 6minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
