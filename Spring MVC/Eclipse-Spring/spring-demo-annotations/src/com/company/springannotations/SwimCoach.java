package com.company.springannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
		
	
	public SwimCoach() {
		System.out.println(">>Inside SwimCoach constructor");
		
	}
	
	//define m init method
	@PostConstruct
	public void doSomeSwimStuff() {
	System.out.println(">>SwimCoach: inside of doSomeSwimStuff()");
	}
	
	
	
	//define m destroy method
	@PreDestroy
	public void destroSwimStuff() {
		System.out.println(">>SwimCoach: inside of destroy6SwimStuff()");
		}

	@Value("${foo.email}")
	private String email;
	
	
	@Value("${foo.team}")
	private String team;


	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 100meters";
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	

}
