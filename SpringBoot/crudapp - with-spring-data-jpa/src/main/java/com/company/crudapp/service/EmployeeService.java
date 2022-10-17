package com.company.crudapp.service;

import com.company.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findALl();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);
}
