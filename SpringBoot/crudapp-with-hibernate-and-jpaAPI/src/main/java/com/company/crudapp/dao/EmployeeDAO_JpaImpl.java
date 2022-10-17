package com.company.crudapp.dao;

import com.company.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
//
// ---------------------JPA API METHOD ----------------------
//  in JPA, we use entityManager instead of hibernate Session
//
@Repository
public class EmployeeDAO_JpaImpl implements EmployeeDAO{

    //define field for entity manager, EntityManager automatically created by Spring Boot
    private EntityManager entityManager;

    //set up constructor injection - @Autowired -
    @Autowired
    public EmployeeDAO_JpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findALl() {

        //create query . This is JPA API

        Query query =
                entityManager.createQuery("from Employee order by firstName");

        //execute query and get the result list
        List<Employee> employees = query.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the employee
        Employee employee =
                entityManager.find(Employee.class, theId);

        //return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {

        //save or update Employee

        // save is performed if id = 0;
        // update is performed if id != 0

        Employee theEmployee = entityManager.merge(employee);



        //update with id from db... so we can get generated id for save/insert
        //it is useful for REST API
        //
        // When you make use of native Hibernate API -saveOrUpdate(), Hibernate will automatically
        // set the object id in the background. However, when you use JPA
        // (per the JPA specification), the object is not updated in the background.
        // As a result, with JPA we have to manually set the value.
        //
        employee.setId(theEmployee.getId());

    }

    @Override
    public void deleteById(int theId) {

        //delete the employee with primary key

        Query query =
                entityManager.createQuery("delete from Employee where id=:employeeId");

        //setting id to the query id parameter
        query.setParameter("employeeId", theId);

        //executing query
        query.executeUpdate();

    }
}
