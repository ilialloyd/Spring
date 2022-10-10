package com.company.springdemo.restController.exceptionHandling;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
step 1: Create CustomerErrorResponse
step 2: Create CustomerNotFoundException
step 3: Create CustomerRestExceptionHandler and define @ControllerAdvice and @ExceptionHandler
step 4: if method in REST Controller to catch exception


 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
    
}
