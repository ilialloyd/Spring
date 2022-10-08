package com.company.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class ChessCoach implements Coach, DisposableBean {

	@Override
	public String getDailyWorkout() {
		return "Read 30 min Kaspoarov's book";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	public void doBeforeMethod() {
		System.out.println("First you should have chess board front of you before reading");
	}

	public void doDestroy() {
		System.out.println("Pack your board when you finish");
	}

	// if i have prototype scope, then if I need to call destroy method,
	//first I need to implement DisposableBean and then overrite its method
	

	@Override
	public void destroy() throws Exception {
	System.out.println("This is overwritten destroy method ");

	}

}
