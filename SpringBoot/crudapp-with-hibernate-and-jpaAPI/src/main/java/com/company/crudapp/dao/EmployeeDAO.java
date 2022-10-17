package com.company.crudapp.dao;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------


 */

import com.company.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findALl();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);

}
