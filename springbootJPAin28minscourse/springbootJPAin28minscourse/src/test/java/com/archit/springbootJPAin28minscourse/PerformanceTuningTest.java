package com.archit.springbootJPAin28minscourse;

import com.archit.springbootJPAin28minscourse.entity.Course;
import com.archit.springbootJPAin28minscourse.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import java.util.List;

@SpringBootTest
@Slf4j
public class PerformanceTuningTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void creatingNPlusOneProblem(){
        List<Course> courses =
                entityManager.createNamedQuery("query_get_all_courses",Course.class).getResultList();

        for(Course course : courses) {
            log.info("Course -> {} Students -> {}" , course , course.getStudents() );
        }
    }


    @Test
    @Transactional
    public void solvingNPlusOneProblem(){
        EntityGraph<Course> entityGraph = entityManager.createEntityGraph(Course.class);
        Subgraph<Object> subgraph = entityGraph.addSubgraph("students");

        List<Course> courses =
                entityManager.createNamedQuery("query_get_all_courses",Course.class)
                        .setHint("javax.persistence.loadgraph", entityGraph)
                        .getResultList();

        for(Course course : courses) {
            log.info("Course -> {} Students -> {}" , course , course.getStudents() );
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblemJoinFetch(){

        List<Course> courses =
                entityManager.createNamedQuery("query_get_all_courses_join_fetch",Course.class)
                        .getResultList();

        for(Course course : courses) {
            log.info("Course -> {} Students -> {}" , course , course.getStudents() );
        }
    }

}
