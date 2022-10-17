package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data
    private List<Employee> employeeList;


    @PostConstruct
    private void loadData() {
        //create employee
        Employee emp1 = new Employee(1, "Lee Ann", "Sarson", "sarson@gmail.com");
        Employee emp2 = new Employee(2, "Shawn", "Gibson", "gibson@gmail.com");
        Employee emp3 = new Employee(3, "Kerry", "Brown", "kerry@gmail.com");

        //create the list
        employeeList = new ArrayList<>();


        //add to the list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }

    //add mapping for /list
    @GetMapping("/list")
    public String getEmployeeList(Model model) {

        model.addAttribute("employees",employeeList);

        //return HTML tempelate name
        return "list-employees";
    }
}
