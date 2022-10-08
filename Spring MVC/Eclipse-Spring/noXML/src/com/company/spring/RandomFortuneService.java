package com.company.spring;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create array of strings
	private String[] data = {
			"Beaware of thre wolf in sheep's clothing",
			"You lucky duck",
			"If you want to success, have some luck with yourself"
	};
	
	//create random number generator
	private Random random = new Random();
	

	@Override
	public String getFortune() {
		// pick random string from the array
		int index = random.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}
