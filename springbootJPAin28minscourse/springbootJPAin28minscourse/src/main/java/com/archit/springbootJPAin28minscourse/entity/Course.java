package com.archit.springbootJPAin28minscourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@NamedQueries(
        value = {
                @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
                @NamedQuery(name = "query_get_all_courses_join_fetch", query = "Select c From Course c JOIN FETCH c.students s")
        }
)
@Cacheable
//THIS ANNOTATION WILL EXECUTE THE SQL WHENEVER DELETE IS CALLED.
@SQLDelete(sql= "update course set is_deleted=true where id=?")
//THIS WILL BE ADDED TO ALL FETCH CONDITIONS
@Where(clause = "is_deleted=false")
@Slf4j
public class Course {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    //SINCE THIS IS NON OWNING SIDE OF THE RELATION (NO COLUMN IN COURSE TABLE) HENCE MAPPEDBY
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    List<Student> students = new ArrayList<>();

    @Getter
    @Setter
    private boolean isDeleted;

    @PreRemove
    private void preRemoved(){
        log.info("COURSE GETTING REMOVED");
        this.isDeleted = true;
    }

    public Course(String name) {
        this.name = name;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
