package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    //BY DEFAULT ONETOONE HAS EAGER FETCH
    @OneToOne(fetch = FetchType.LAZY)
    Passport passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE"
            , joinColumns = @JoinColumn(name = "STUDENT_ID")
            , inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
