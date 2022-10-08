package com.company.springannotations;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("jump")
public class JumpingCoach implements Coach {

	
	private FortuneService fortuneService;
	
	
	
	
	public JumpingCoach() {
		
	}
	
	@PostConstruct
	public void doSomeLuck() {
		System.out.println("Some BADLuck before starting");
		System.out.println(getDailyFortune());
	}

	@Autowired
	public JumpingCoach(@Qualifier("badluck") FortuneService fortuneService) {
		System.out.println(">>Inside JumpingCoach constructor - @Autowired,@Qualifier");
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "you need to run quick and jump high as much as ou can";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
