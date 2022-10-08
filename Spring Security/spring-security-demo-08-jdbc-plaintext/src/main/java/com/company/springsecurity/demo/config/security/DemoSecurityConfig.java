package com.company.springsecurity.demo.config.security;


/*
 <--------------------This is depricated method--------------.>
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test1234").roles("EMPLOYEE"))
                .withUser(users.username("susan").password("test").roles("ADMIN"));


    }
}
                               instead
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    //add a reference to our security data source

    private DataSource securityDataSource;


    @Autowired
    public DemoSecurityConfig(DataSource securityDataSource){
        this.securityDataSource=securityDataSource;
    }

    //tell Spring Security to use JDBC authentication with our data source
    @Bean
    public UserDetailsManager userDetailsManager(){
        return new JdbcUserDetailsManager(securityDataSource);
    }






    //configure security of web paths in application, login, logout

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(configurer ->
                        configurer
                                //.anyRequest()  anyRequest open to everyone, but we now will restrict access
                                //.authenticated()) //depend of roles of employees
                                .antMatchers("/").hasRole("EMPLOYEE") //path and role
                                .antMatchers("/leaders/**").hasRole("MANAGER")
                                .antMatchers("/systems/**").hasRole("ADMIN")
                )


                //login configurer
                .formLogin(configurer ->
                        configurer
                                .loginPage("/showLoginPage")
                                //login form should POST data to this URL for processing(check user id and password)
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()//everyone can access if they pass whole process
                )
                //logout configuration
                .logout(configurer ->
                        configurer
                                .permitAll())
                 //access denied configuration
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                )
                .build();


    }

}
