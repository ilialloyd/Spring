package com.example.bootapp.rest;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    // add mapping -  expose " / " return "Hello World"
    @GetMapping("/")
    public String hello(){
        return "Hello World! Time on server is: "+ LocalDateTime.now();
    }

    @GetMapping("/wakeUp")
    public String getUp(){
      return "Weyki Weykiiii";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Today run 5k!";
    }

}
