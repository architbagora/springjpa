package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@NamedQueries(
    value = {
            @NamedQuery(name="query_get_all_courses", query = "Select c From Course c")
    }
)
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
    List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
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
