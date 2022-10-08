package com.example.noXML.fortuneIMPL;

import com.example.noXML.interfaces.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// pick random string from the array
		RandomLuck luck = new RandomLuck();
		System.out.println("RandomLuck Object Created");
		String rLuck =luck.giveRandomLuck();
		return rLuck;
	}

}
