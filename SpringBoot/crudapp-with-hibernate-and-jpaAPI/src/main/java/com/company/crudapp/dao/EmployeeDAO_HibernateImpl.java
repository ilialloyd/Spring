package com.company.crudapp.dao;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
@Repository Annotation - is a specialization of @Component annotation
which is used to indicate that the class provides the mechanism for
 storage, retrieval, update, delete and search operation on objects
 *
 @Transactional - handles transaction management, So we don't have to
 manually start and commit transaction

 */

import com.company.crudapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
//
//
//// ---------------------Native Hibernate METHOD ----------------------
//
//
@Repository
public class EmployeeDAO_HibernateImpl implements EmployeeDAO {

    //define field for entity manager, EntityManager automatically created by Spring Boot
    private EntityManager entityManager;

    //set up constructor injection - @Autowired -
    @Autowired
    public EmployeeDAO_HibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findALl() {

        //get the current hibernate session

        Session currentSession = entityManager.unwrap(Session.class);

        //create query . This is native Hibernate API
        Query<Employee> query =
                currentSession.createQuery("from Employee order by firstName", Employee.class);

        //execute query and get the result list
        List<Employee> employees = query.getResultList();


        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee employee =
                currentSession.get(Employee.class, theId);

        //return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save Employee
        //if id=0 enter new entry, if id match up then update
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int theId) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete the employee with primary key
        //giving id parameter
        Query query =
                currentSession.createQuery("delete from Employee where id=:employeeId");

        //setting id to the query id parameter
        query.setParameter("employeeId", theId);

        //executing query
        query.executeUpdate();


    }
}
