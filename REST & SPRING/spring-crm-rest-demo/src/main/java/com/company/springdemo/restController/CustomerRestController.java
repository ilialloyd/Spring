package com.company.springdemo.restController;

import com.company.springdemo.entity.Customer;
import com.company.springdemo.restController.exceptionHandling.CustomerNotFoundException;
import com.company.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

    //autowire the CustomerService
    @Autowired
    CustomerService customerService;


    //add mapping for get/customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //get customer by its id
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        //in here, if Customer cant find related id object it return null and pass referance to the method

        Customer theCustomer = customerService.getCustomer(customerId);
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        //so that is why JSON will return empty page
        return theCustomer;
    }

    //add mapping for POST / customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        //also just in case the pass an id in JSON ...set id to 0
        //this is force the save of new item instead of update
        //because there is no any customer with index 0; it will autoincrement id

        //we save saveorupdate method in DAO
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;

        //go to Postman, -> POST, paste Link, -> body ->raw -> choose JSON -> add new  customer
        //   {
        //    "firstName" : "Lee Ann",
        //    "lastName" : "Sarson",
        //    "email" : "leeann@gmail.com"
        //   }

        //if you get 405 ERROR check this out
        // https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/25253580#questions
    }


    //add mapping for PUT / customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        //if customer has existing id, it will update the customer
        customerService.saveCustomer(theCustomer);

        return theCustomer;

        /*
        go to Postman, -> PUT, /api/customers, -> body ->raw -> choose JSON -> update   customer

        {
            "id" : 2,    give existing id
                "firstName" : "Tom",
                "lastName" : "Kalathari",
                "email" : "tom.k@gmail@gmail.com"
        }

         */

    }


    //add mapping for DELETE / customers - delete existing customer
    @DeleteMapping("/customers/{customerID}")
    public String deleteCustomer(@PathVariable int customerID) {


        //first we're going to check if customer exist otherwise we will throw Exception
        //get customer
        Customer theCustomer = customerService.getCustomer(customerID);
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerID);
        }

        //delete customer

        customerService.deleteCustomer(customerID);


        return "Deleted customer id - "+customerID;
    }
}
