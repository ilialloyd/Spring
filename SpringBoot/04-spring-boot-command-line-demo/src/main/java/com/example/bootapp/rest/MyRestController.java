package com.example.bootapp.rest;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    //inject properties for coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;



    //new endpoint for team info
    @GetMapping("/teaminfo")
        public String getTeamInfo(){
            return "Coach name: "+coachName+" \nTeam name: "+teamName;
        }


    // add mapping -  expose " / " return "Hello World"
    @GetMapping("/")
    public String hello() {
        return "Hello World! Time on server is: " + LocalDateTime.now();
    }

    @GetMapping("/wakeUp")
    public String getUp() {
        return "Weyki Weykiiii";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Today run 5k!";
    }

}
