package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course , Long> {

    List<Course> findByName(String name);
    List<Course> findByNameAndId(String name, Long id);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);

    @Query("Select c From Course c where name like '%100 Steps'")
    List<Course> courseWith100StepsInName(String name);

    @Query(value = "Select * From Course c where name like '%100 Steps'" , nativeQuery = true)
    List<Course> courseWith100StepsInNameUsingNativeQuery(String name);


    @Query(name = "query_get_all_courses")
    List<Course> courseWith100StepsInNameUsingNamedQuery(String name);

}
