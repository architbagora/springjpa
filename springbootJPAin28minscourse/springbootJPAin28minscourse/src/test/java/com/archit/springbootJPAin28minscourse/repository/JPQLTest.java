package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import com.archit.springbootJPAin28minscourse.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Slf4j
public class JPQLTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void jpql_basic(){
        List resultList = entityManager.createQuery("Select c from Course c").getResultList();
        log.info("Select c from Course => {}", resultList);
    }

    @Test
    public void jpql_named_query_basic(){
        List resultList = entityManager.createNamedQuery("query_get_all_courses").getResultList();
        log.info("Select c from Course => {}", resultList);
    }

    @Test
    public void jpql_typed(){
        List<Course> resultList = entityManager.createQuery("Select c from Course c", Course.class).getResultList();
        log.info("Select c from Course => {}", resultList);
    }

    @Test
    public void jpql_where(){
        List<Course> resultList = entityManager.createQuery("Select c from Course c where name like '%steps'", Course.class).getResultList();
        log.info("Select c from Course => {}", resultList);
    }

    @Test
    public void jpql_cousers_without_students(){
        List<Course> resultList = entityManager.createQuery("Select c from Course c where c.students is empty", Course.class).getResultList();
        log.info("Select c from Course without students => {}", resultList);
    }

    @Test
    public void jpql_cousers_with_atleast_2_students(){
        List<Course> resultList = entityManager.createQuery("Select c from Course c where size(c.students) >=2 ", Course.class).getResultList();
        log.info("Select c from Course withat least 2 students => {}", resultList);
    }

    @Test
    public void jpql_cousers_with_orderby_students(){
        List<Course> resultList = entityManager.createQuery("Select c from Course c order by size(c.students) desc", Course.class).getResultList();
        log.info("Select c from Course orderby least 2 students => {}", resultList);
    }

    @Test
    public void jpql_cousers_with_passport_in_certain_pattern(){
        List<Student> resultList = entityManager.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class).getResultList();
        log.info("Students with certain passport pattern => {}", resultList);
    }


    @Test
    public void jpql_joins(){
        List<Object[]> resultList = entityManager.createQuery("Select  c,s from Course c JOIN c.students s").getResultList();
        for(Object[] resultObjs : resultList){
            log.info("course {} Students {} ", resultObjs[0], resultObjs[1] );
        }
    }

    @Test
    public void jpql_left_joins(){
        List<Object[]> resultList = entityManager.createQuery("Select  c,s from Course c LEFT JOIN c.students s").getResultList();
        for(Object[] resultObjs : resultList){
            log.info("course {} Students {} ", resultObjs[0], resultObjs[1] );
        }
    }


    @Test
    public void jpql_cross_joins(){
        List<Object[]> resultList = entityManager.createQuery("Select  c,s from Course c , Student s").getResultList();
        for(Object[] resultObjs : resultList){
            log.info("course {} Students {} ", resultObjs[0], resultObjs[1] );
        }
    }

}
