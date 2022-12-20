package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.inheritance.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    //Insert Employee
    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    //retrieve all the employee
    public List<Employee> retrieveAllEmployee(){
        return entityManager.createQuery("select e from Employee e" , Employee.class).getResultList();
    }

}
