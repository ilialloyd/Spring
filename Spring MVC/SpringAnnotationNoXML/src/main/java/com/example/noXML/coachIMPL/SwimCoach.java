package com.example.noXML.coachIMPL;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.example.noXML.interfaces.Coach;
import com.example.noXML.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Value;


public class SwimCoach implements Coach {

    private FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;

    @Value("${foo.name}")
    private String name;




    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }




    //constructor
    public SwimCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Swim 100m as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}
