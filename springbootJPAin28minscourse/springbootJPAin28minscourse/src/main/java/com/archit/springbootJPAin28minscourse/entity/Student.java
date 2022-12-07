package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    public Student(){
    }

    public Student(String name){
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
