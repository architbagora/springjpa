package com.archit.springbootJPAin28minscourse;

import com.archit.springbootJPAin28minscourse.entity.Course;
import com.archit.springbootJPAin28minscourse.entity.Person;
import com.archit.springbootJPAin28minscourse.entity.Review;
import com.archit.springbootJPAin28minscourse.entity.Student;
import com.archit.springbootJPAin28minscourse.jdbc.PersonJdbcDao;
import com.archit.springbootJPAin28minscourse.jpa.PersonJpaRepository;
import com.archit.springbootJPAin28minscourse.repository.CourseRepository;
import com.archit.springbootJPAin28minscourse.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class JPAin28minscourseApplication implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Autowired
    CourseRepository courseRepository;


    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JPAin28minscourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        courseRepository.addReviewsForCourse();

        //System.out.println(courseRepository.findById(10001l));

        //studentRepository.saveStudentWIthPassport();
        //courseRepository.deleteById(10001l);

//        log.info("Single users -> {}", personJpaRepository.findById(10001));
//        log.info("Insert users -> {}", personJpaRepository.insert(new Person(10004, "Taw", "bangalore", new Date())));
//        log.info("Insert users -> {}", personJpaRepository.update(new Person(10004, "Paw", "bangalore", new Date())));
//        personJpaRepository.deleteById(10002);
//        log.info("All users -> {}", personJpaRepository.findAll());
    }


}
