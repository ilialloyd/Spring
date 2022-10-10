package com.company.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 * https://www.studytonight.com/spring-boot/spring-boot-global-exception-handling
This is global Exception Handling style
 So instead of writing exceptions in every class, it's better to create seperate exception class and
 Annotate with @ControllerAdvice. so  if we want to delete some classes, our exceptions will be safe
 */
@ControllerAdvice
public class StudentRestExceptionHandling {

    //add Exception handling code here
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        //we create new response entity and give it to boyd, which it is error, and the status

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(Exception exception){

        //create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        //we create new response entity and give it to boyd, which it is error, and the status

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
