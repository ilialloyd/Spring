package com.company.crudapp.service;


import com.company.crudapp.dao.EmployeeRepository;
import com.company.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//
//
// With Spring Data Jpa we don't need @Transactional as well. because JpaRepository
// provides this functionality
//
//

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //delegate the calls to the DAO -DAO temsilcilerini caqir
    @Override
    public List<Employee> findALl() {


        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //in here we use optional pattern
        //Optional in Java is a container for an object that may or may not hold a value.
        // This is a fact seldom understood amongst Java engineers who use Optional as a
        // 'fancy way' to perform null checks and to avoid NullPointerException scenarios.
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee =null;

        if(result.isPresent()){
       theEmployee = result.get();
        } else{
            //we didnt find the employee
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
