package com.example.noXML.coachIMPL;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.example.noXML.interfaces.Coach;
import com.example.noXML.interfaces.FortuneService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SoccerCoach implements Coach {

private FortuneService niceFortuneService;

    public SoccerCoach(FortuneService niceFortuneService) {
        this.niceFortuneService = niceFortuneService;
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("@@@ " +  getClass().getName() + ": inside of doMyStartupStuff()");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("@@@ " +  getClass().getName() + ": inside of doMyCleanupStuff()");
    }

    @Override
    public String getDailyWorkout() {
        return "Work with your right side";
    }

    @Override
    public String getDailyFortune() {
        return niceFortuneService.getFortune();
    }
}
