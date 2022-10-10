package com.company.jackson.json.demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();


            // read JSON  file and map/convert to Java POJO:
            // data/sample-lite.json
            Student student1 = mapper.readValue(new File("data/sample-lite.json"),Student.class);


            // data/sample-full.json
            Student student = mapper.readValue(new File("data/sample-full.json"),Student.class);

            // print first name and last name
            System.out.println("First name: "+student.getFirstName()
                            + "\nLast Name : "+student.getLastName());

            //address
            Address tempAddress = student.getAddress();
            System.out.println("State: "+tempAddress.getState()
                    +"\nCity :"+tempAddress.getCity()
                    +"\nStreet:"+tempAddress.getStreet());

            //language
            for(String language : student.getLanguages()){
                System.out.println(language);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



