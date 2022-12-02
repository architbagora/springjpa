package com.archit.springbootJPAin28minscourse;

import com.archit.springbootJPAin28minscourse.entity.Person;
import com.archit.springbootJPAin28minscourse.jdbc.PersonJdbcDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
@Slf4j
public class SpringJDBCin28minscourseApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCin28minscourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("All users -> {}", personJdbcDao.findAll());
        log.info("Single users -> {}", personJdbcDao.findById(10001));
        log.info("Deleted users -> {}", personJdbcDao.deleteById(10002));
        log.info("Insert users -> {}", personJdbcDao.insert(new Person(10004, "Taw", "bangalore", new Date())));
        log.info("Insert users -> {}", personJdbcDao.update(new Person(10004, "Paw", "bangalore", new Date())));

    }
}
