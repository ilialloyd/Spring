package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */
@Configuration
@ComponentScan("com.company")
public class ApplicationConfig extends WebMvcConfigurationSupport {


    protected void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("css/**","images/**").          //if you have image folder or css folder
        addResourceLocations("classpath/css/", "classpath:/images/");          //folder linkleri
    }
    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

}
