package com.company.springdemo.rest;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
Why this class?
This depends on your project requirements. We set status on
StudentErrorResponse class to send additional information
that we set in the object. This information will be used for
the Frontend team. So the Frontend team simply takes a look at the response
object and uses it information. However, if we only set status code in
ResponseEntity, this information will not be included to our object.

 */

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
