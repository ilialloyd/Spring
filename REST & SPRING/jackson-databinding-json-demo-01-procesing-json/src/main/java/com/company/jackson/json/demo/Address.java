package com.company.jackson.json.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
if we want to run  full one we will need to create new Class.
Because it is nested Object.

 */
@Getter
@Setter
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String zip;
    private String country;
    private String state;




}
