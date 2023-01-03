package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class CourseSpringDataRepositoryTest {

    @Autowired
    CourseSpringDataRepository springDataRepository;

    @Test
    public void findByIdTest(){
        Optional<Course> course =  springDataRepository.findById(10001L);
        System.out.println("course *******************"+ course);
    }

    @Test
    public void sort(){
        Sort sort =  Sort.by(Sort.Direction.DESC, "name");
        System.out.println("course ALL *******************"+ springDataRepository.findAll(sort));
    }

    @Test
    public void pagination(){
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Course> firstPage = springDataRepository.findAll(pageRequest);
        System.out.println("course FIRST PAGE *******************"+ firstPage.getContent());

        Pageable secondPagable = firstPage.nextPageable();
        Page<Course> secondPage = springDataRepository.findAll(secondPagable);
        System.out.println("course SECOND PAGE *******************"+ secondPage.getContent());
    }

    @Test
    public void findByName(){
        System.out.println("course ALL *******************"+ springDataRepository.findByName("Dummy 1"));
    }

}
