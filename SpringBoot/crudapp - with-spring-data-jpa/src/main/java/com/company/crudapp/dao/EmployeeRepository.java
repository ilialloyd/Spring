package com.company.crudapp.dao;

import com.company.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Before we used to use DAOImpl to implement and execute some
    // actions like : findAll(), getById(), save() and etc. in Hibernate or JPA

    //But Spring Data JPA JpaRepository Spring Data will provide all the methods
    //So, No need to write code in our case
    //
}
