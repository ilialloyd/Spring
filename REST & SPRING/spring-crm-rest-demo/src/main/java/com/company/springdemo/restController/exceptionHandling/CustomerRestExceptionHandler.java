package com.company.springdemo.restController.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */
@ControllerAdvice
public class CustomerRestExceptionHandler {

    //add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception){

        //create CustomerErrorResponse
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(), //status
                exception.getMessage(),       //message
                System.currentTimeMillis()    //time
        );



        //return ResponseEntity
                                   //body   //status code        of the shown message
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Add another exception  handler that catch any exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception){
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );


        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
