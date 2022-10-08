package com.example.noXML.coachIMPL;

import com.example.noXML.interfaces.Coach;
import com.example.noXML.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//	<bean id="myCoach" 
//class="com.company.springdemo.TrackCoach">
/* id myCoach is the same with annotation myCoach

By default, yəni əgər 
@Component - olaraq istifadə edərəmsə özü class adını götürüb
 onun ilk hərfini kiçik hərfə çevirir. O şəkildə sonra istifadə edilə bilər
 TennisCoach -> tennisCoach (default Bean iD)

 */

// @Scope("prototype") //singleton default changes. it will allow to create 2 different objects of same class
@Component("tennisCoach")   //@Component("myCoach") - if you want to gice spesific id
public class TennisCoach implements Coach {

	
	//with field injection we can set field without setter method
	//if works with reflection 

	//@Qualifier - əgər bir neçə implementasiya varsa, işlətmək istədiinin adını
	//default verərək çağıra bilərsən
	@Autowired
	@Qualifier("randomFortuneService") //we call exactly which interface we need
	private FortuneService fortuneService;

	
public TennisCoach() {
	//	System.out.println(">> Inside TennisCoach constructor");
	}
	public TennisCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}

/*	

	// if class has one constructor with parameter you actually dont need to use
	// @Autowired annotation
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
*/
	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
