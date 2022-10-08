package com.example.noXML.interfaces;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.example.noXML.config.Practise7Config;
import com.example.noXML.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Practise7Main {
    public static void main(String[] args) {
        //define spring container
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Practise7Config.class);

        //retrieve from the container
        Coach coach = context.getBean("soccerCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());


        context.close();

    }

}
