package com.company.crudapp.dao;

import com.company.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//     Before we used to use DAOImpl to implement and execute some
//     actions like : findAll(), getById(), save() and etc. in Hibernate or JPA
//     Spring Data JPA JpaRepository Spring Data will provide all the methods
//     So, No need to write code in our case

    /*
   *  Spring Data REST endpoint Takes <Employee>  -> first character lowercase
     and adding s int the end to make it "/employees" mapping

   *  IF you want to give custom mapping: "/employees" -> "/workers"
     @RepositoryRestResource(path="workers")
     public interface EmployeeRepository extends JpaRepository<Employee, Integer>
     localhost:8080/workers



  *  When you delete employee, use id the link in JSON. you dent need to add extra id

     */
}
