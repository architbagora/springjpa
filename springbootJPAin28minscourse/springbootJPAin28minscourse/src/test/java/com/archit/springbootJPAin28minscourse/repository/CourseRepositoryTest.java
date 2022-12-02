package com.archit.springbootJPAin28minscourse.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findByIdTest(){
        Assertions.assertEquals("jpa in 50 steps",courseRepository.findById(10001L).getName());
    }

    @Test
    @DirtiesContext
    public void DeleteByIdTest(){
        courseRepository.deleteById(10002L);
        Assertions.assertNull(courseRepository.findById(10002L));
    }



    @Test
    @DirtiesContext
    public void playWithEntityManager(){
        courseRepository.palyWithEntityManager();
    }
}
