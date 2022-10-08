package com.example.noXML.fortuneIMPL;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.example.noXML.interfaces.FortuneService;

public class NiceFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "I feel that you will gool today";
    }
}
