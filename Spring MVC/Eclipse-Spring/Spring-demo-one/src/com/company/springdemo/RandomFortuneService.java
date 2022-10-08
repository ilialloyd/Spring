package com.company.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	String [] fortune = {"You are in your lucky day my friend","you lucky duck, go get it"
			, "You are in shape: Do it!"};
	

	@Override
	public String getFortune() {
		int randomNumber = new Random().nextInt(fortune.length);
		
		return fortune[randomNumber];
	}

}
