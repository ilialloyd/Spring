package com.company.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */
@Controller
public class LoginController {


    @GetMapping("/showLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }
}
