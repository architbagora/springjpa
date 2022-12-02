package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
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
}
