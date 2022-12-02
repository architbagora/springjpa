package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    //TO extend transaction to this test case and make sure student.passport is also able to call otherwise below exception
    //org.hibernate.LazyInitializationException: could not initialize proxy [com.archit.springbootJPAin28minscourse.entity.Passport#40001] - no Session
    @Transactional
    public void findStudentById(){
        Student student = entityManager.find(Student.class, 20001l);

        //ONE TO ONE is Always eager fetch By Default
        log.info("Student -> {}" , student);
        //PUT DEBUGGER TO SEE
        log.info("Passport -> {}" , student.getPassport());

    }




}
