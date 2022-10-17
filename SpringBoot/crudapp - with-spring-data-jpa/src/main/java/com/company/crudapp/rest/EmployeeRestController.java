package com.company.crudapp.rest;


import com.company.crudapp.entity.Employee;
import com.company.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    //inject employee dao directly

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose "/employees" and return all list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findALl();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    //add new employee
    // if you need new Data from JSON you need to use @RequestBody
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        //if You use Spring Data Jpa, when you add new Entry you dent need to add id
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        //throw exception if there is no user with this id
        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee id - "+ employeeId;
    }
}
