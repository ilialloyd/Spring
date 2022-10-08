package com.company.springannotations.practise;

import org.springframework.stereotype.Component;

import com.company.springannotations.Coach;
import com.company.springannotations.FortuneService;

@Component //by default it will create class name with lower case letter
public class HandballCoach implements Coach {
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		
		return "Hold the ball in your hand and run 5 circle";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
