package com.example.noXML.config;

import com.example.noXML.coachIMPL.SwimCoach;
import com.example.noXML.coachIMPL.TennisCoach;
import com.example.noXML.fortuneIMPL.RandomFortuneService;
import com.example.noXML.fortuneIMPL.SadFortuneService;
import com.example.noXML.interfaces.Coach;
import com.example.noXML.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 * this is actually same thing when we did in XML File
 *
 * <bean id="sadFortuneService"
 * class="com.company.springdemo.SadFortuneService">
 * </bean>
 * <bean id="swimCoach" class="com.company.springdemo.SwimCoach">

 * <!-- set up constructor injection here -->
 * <constructor-arg ref="sadFortuneService" />
 * </bean>
 *
 * @ComponentScan("com.example.noXML") ---used with the @Configuration annotation to
 *  tell Spring the packages to scan for annotated components.
 *
 * <!--  add entry to enable component scanning -->
 * <context:component-scan base-package="com.example.noXML" /> ---or--- @ComponentScan("com.example.noXML")
 * with that method you can actually work with classes inside this package
 * read more - https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/14541004#overview
 */

@Configuration
//@ComponentScan("com.example.noXML")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for our sad fortune service
   @Bean   //method name will be actual bean id as we did in xml file
    public FortuneService sadFortuneService(){
        System.out.println("sadFortuneService called");
        return new SadFortuneService();//injecting dependency

    }

    //define bean for our swim coach and inject dependency
    @Bean  //    The method name determines the bean id.
    public Coach swimCoach(){
        System.out.println("SwimCoach called");
        return new SwimCoach(sadFortuneService());//we call constructor and send reference to its parameter
    }

    @Bean   //method name will be actual bean id as we did in xml file
    public FortuneService randomFortuneService(){
        System.out.println("RandomFortuneService called");
        return new RandomFortuneService();//injecting dependency

    }

    @Bean  //    The method name determines the bean id.
    public Coach tennisCoach(){
        System.out.println("TennisCoach called");
        return new TennisCoach(randomFortuneService());//we call constructor and send reference to its parameter
    }


}
