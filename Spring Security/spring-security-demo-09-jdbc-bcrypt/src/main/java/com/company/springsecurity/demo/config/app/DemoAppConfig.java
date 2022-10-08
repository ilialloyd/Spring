package com.company.springsecurity.demo.config.app;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
           Spring App Configuration(@Configuration)

        <!-- Define Spring MVC view resolver     //same view resolver in pure java-->
           <bean
                 class="org. springframework. web. servlet. view. Interna LResourceViewResol ver ">
                      <property name="prefix " value= "/WEB - INF/view/" />
                      <property name="suffix" value= ". jsp" />
           </bean>
 */


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc //this gives us same functionality as <mvc:annotation-driven>
@ComponentScan(basePackages = "com.company.springsecurity.demo") // this is the base package for annotations
@PropertySource("classpath:persistence-mysql.properties") //this will read resource prob file
public class DemoAppConfig implements WebMvcConfigurer {


    //set up variable to hold the properties
    //this Environment hold the data that read from the properties file, and then we can make use of this data
    //Environment is a special Helper Class from the Spring framework
    @Autowired
    private Environment env;


    //set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());



    //define a bean for ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    //define a bean for our security datasource
    @Bean
    public DataSource securityDataSource(){

        //create connection pool
        ComboPooledDataSource securityDataSource
                                     = new ComboPooledDataSource();

        //set the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }


        //log the connections properties
        //this is to keep things safe, to make sure if we are REALLY reading data from properties file
        logger.info(">>>jdbc.url="+env.getProperty("jdbc.url"));
        logger.info(">>>jdbc.user="+env.getProperty("jdbc.user"));


        //set database connection properties
        //here is important to connect to database. be careful with typo
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        //set the connection pool properties

        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));//it has int value 5

        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));

        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));

        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime"));



        return securityDataSource;
    }

    //need a helper method
    // read environment property and convert to int. Because in property all are Strings


    private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);

        //convert to int
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }

      //css using path
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
}
