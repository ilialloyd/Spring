package com.company.springsecurity.demo.config;


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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails theManager = User.builder()
                .username("cory")
                .password("{noop}test1234") //or .password(encoder(encode))"test1234")
                .roles("MANAGER")
                .build();


        UserDetails theAdmin = User.builder()
                .username("thomas")
                .password("{noop}thomas1234")
                .roles("ADMIN")
                .build();

        UserDetails theEmployee = User.builder()
                .username("amanda")
                .password("{noop}amanda123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(theManager, theAdmin, theEmployee);
    }

    //configure security of web paths in application, login, logout

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http
                .authorizeHttpRequests(configurer ->
                        configurer
                                .anyRequest()

                                .authenticated())
                //.antMatcher("/css/**).permitAll  if you have any css file for error message you need to permit with this method
                .formLogin(configurer ->
                        configurer
                                .loginPage("/showLoginPage")
                                //login form should POST data to this URL for processing(check user id and password)
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())//everyone can access if they pass whole process
                .build();



    }

}
