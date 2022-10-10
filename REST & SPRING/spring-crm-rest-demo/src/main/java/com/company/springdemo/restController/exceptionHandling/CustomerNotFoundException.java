package com.company.springdemo.restController.exceptionHandling;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */

public class CustomerNotFoundException extends RuntimeException{

    //we call all super constructors
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
