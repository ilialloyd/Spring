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


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //this gives us same functionality as <mvc:annotation-driven>
@ComponentScan(basePackages = "com.company.springsecurity.demo") // this is the base package for annotations
public class DemoAppConfig implements WebMvcConfigurer{

    //define a bean for ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

}
