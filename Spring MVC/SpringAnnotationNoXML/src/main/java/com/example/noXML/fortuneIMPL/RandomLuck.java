package com.example.noXML.fortuneIMPL;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import java.util.Random;

public class RandomLuck {
    private  String[] data = {
            "Beware of the wolf in sheep's clothing",
            "You lucky duck",
            "If you want to success, have some luck with yourself"
    };

    private  Random random = new Random();


    public  String giveRandomLuck(){
        int index = random.nextInt(data.length);

        String theFortune = data[index];
        return theFortune;
    }
}
