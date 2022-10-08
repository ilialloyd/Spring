package com.company.springsecurity.demo.controller;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}
