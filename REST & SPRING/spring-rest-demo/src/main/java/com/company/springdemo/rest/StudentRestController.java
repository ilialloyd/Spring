package com.company.springdemo.rest;

import com.company.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */
@RestController
@RequestMapping("/api")
public class StudentRestController {

    //This is better example
    List<Student> students;

    //this is the contract that guarantees that this method will be invoked only once in the bean lifecycle.
    @PostConstruct
    public void loadData() {

        students = new ArrayList<>();

        students.add(new Student("Shawn", "Gibson"));
        students.add(new Student("Ruth", "Walton"));
        students.add(new Student("Michael", "Far"));

    }

    //getting student's by id
    @GetMapping("/student")
    public List<Student> getStudents() {
        return students;
    }


    //define endpoint for /student/{studentId} getting student by it's ID
    //int studentId  and  {studentId} should be same typo
    // to refer path variable -{studentId} we use @PathVariable

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        //check the studentId against list size
        if(studentId>=students.size() || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        //if no exception it returns works
        return students.get(studentId);
    }

/*
    ---------we use global Exception handling instead of manual that is why we cut them
    //so far in the up we have logik that throws exception.
    //now we need to handle that exception

    //ResponseEntity represents an HttpResponse and includes headers,
    // body, and status.  @ResponseBody allows us to put the return value
    // into the body of the response but ResponseEntity also allows us to
    // add headers and status code.
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

    //add another exception handler ...to catch any kind of exception

    //The exception handler will try to find the specific exception(MyException) handler firstly, if not it will try to find the generic exception(Exception).
    //
    //so for your example, when controller throw MyException, the handler will invoke the MyException handler.

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

 -----------------------------------------------------------------------------------------------

    //endpoint for students. just this gives you all students
    @GetMapping("/student")
    public List<Student> getStudents(){

     // this is bad example because anytime we call method we will create new Arraylist object
        List<Student> listStudents = new ArrayList<>();

        listStudents.add(new Student("Shawn","Gibson"));
        listStudents.add(new Student("Ruth","Walton"));
        listStudents.add(new Student("Michael","Far"));

        return listStudents;
    }
     */


}
