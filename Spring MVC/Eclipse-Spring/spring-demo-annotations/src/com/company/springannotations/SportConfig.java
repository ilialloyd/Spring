package com.company.springannotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
@Lazy
@Configuration
@ComponentScan("com.company.springannotations")
public class SportConfig {

}
