package com.company.spring;

import org.springframework.stereotype.Component;


//	<bean id="myFortuneService"
//class="com.company.springdemo.HappyFortuneService"></bean>

@Component  //so we register class in spring container
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Have a good luck you rock";
	}

}
