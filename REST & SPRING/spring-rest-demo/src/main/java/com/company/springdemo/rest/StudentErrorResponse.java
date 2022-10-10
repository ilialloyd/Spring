package com.company.springdemo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;


}
