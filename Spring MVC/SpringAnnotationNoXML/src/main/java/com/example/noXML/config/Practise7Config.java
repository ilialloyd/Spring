package com.example.noXML.config;

import com.example.noXML.coachIMPL.SoccerCoach;
import com.example.noXML.fortuneIMPL.NiceFortuneService;
import com.example.noXML.interfaces.Coach;
import com.example.noXML.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */
@Configuration

public class Practise7Config {

    @Bean
    public FortuneService niceFortuneService(){
        return new NiceFortuneService();
    }

    @Bean
    public Coach soccerCoach(){
        return new SoccerCoach(niceFortuneService());

    }

}
