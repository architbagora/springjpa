package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
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
    public void softDeleteByIdTest(){
        courseRepository.deleteById(10004L);
        Assertions.assertNull(courseRepository.findById(10004L));
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager(){
        courseRepository.palyWithEntityManager();
    }



    //Since the calls are not in same transaction hence wont be cached.
    @Test
    public void firstLevelCache_Not_working(){
        Course course1 = courseRepository.findById(10001L);
        log.info("Course First time "+ course1);
        Course course2 = courseRepository.findById(10001L);
        log.info("Course Second time "+ course2);

    }


    //Transaction scope is this method now hence it will be cached.
    @Test
    @Transactional
    public void firstLevelCache_working(){
        Course course1 = courseRepository.findById(10001L);
        log.info("Course First time "+ course1);
        Course course2 = courseRepository.findById(10001L);
        log.info("Course Second time "+ course2);

    }
}
