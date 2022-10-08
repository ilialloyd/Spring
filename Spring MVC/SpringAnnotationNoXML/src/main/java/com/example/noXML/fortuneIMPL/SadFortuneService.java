package com.example.noXML.fortuneIMPL;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import com.example.noXML.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
