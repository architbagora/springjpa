package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import com.archit.springbootJPAin28minscourse.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Transactional
@Repository
@Slf4j
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void palyWithEntityManager(){
        Course course1 = new Course("Web services in 100 steps");
        entityManager.persist(course1);

        Course course2 = new Course("Angular JS in 100 steps");
        entityManager.persist(course2);

        //When actually the quries are fired
        entityManager.flush();

        course1.setName("Web services in 100 steps - Updated");

        course2.setName("Angular JS in 100 steps - Updated");

        //Course1 is reset now.
        entityManager.refresh(course1);

        //Entity manager is will detach and stop tracking it.
        entityManager.detach(course2);

        //quries fired for only course2
        entityManager.flush();
    }


    public void addReviewsForCourse() {
        Course course = findById(10003l);
        log.info("Course reviews are {}", course.getReviews());

        //add 2 review to it
        Review review1 = new Review("5","Awesome job ranga");
        Review review2 = new Review("5","hatsoff");

        //Setting up relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //SAVE TO DB
        entityManager.persist(review1);
        entityManager.persist(review2);

    }

}
