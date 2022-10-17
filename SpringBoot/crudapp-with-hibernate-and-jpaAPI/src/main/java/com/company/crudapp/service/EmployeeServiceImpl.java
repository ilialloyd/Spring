package com.company.crudapp.service;


import com.company.crudapp.dao.EmployeeDAO;
import com.company.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//
//
//If you have more than 1 Implementation of DAO , with @Qualifier you can choose,
// which to call in Service.
// Default bean id is always class name with lowercase letter. So if I want to
// import then I will use lowercase version "EmployeeDAOJpaImpl" -> "employeeDAOJpaImpl"
//
//
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(
            @Qualifier("employeeDAO_JpaImpl") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //delegate the calls to the DAO -DAO temsilcilerini caqir
    @Override
    @Transactional
    public List<Employee> findALl() {


        return employeeDAO.findALl();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
