package com.company.springannotations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("badluck")
public class BadLuckFortuneService implements FortuneService {
	private final String filename = "badluck.txt";
	
	

	private String[] array;

	
	public BadLuckFortuneService() throws Exception {
		fileToArray();
	}
	
	
	

	private String[] fileToArray() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		List<String> lines = new ArrayList<String>();
		String line = "";

		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		reader.close();

		array = lines.toArray(new String[] {});
		return array;
	}

	private String randomBadLuck() {
		Random random = new Random();
		int number = random.nextInt(array.length);
		String luck = array[number];
		return luck;
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return randomBadLuck();
	}

}
