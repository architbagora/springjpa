package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Transactional
@Repository
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

}
