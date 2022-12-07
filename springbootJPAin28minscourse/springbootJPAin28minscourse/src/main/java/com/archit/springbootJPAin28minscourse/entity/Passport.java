package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    //PASSPORT TABLES DOESNT OWN THE RELATIONSHIP(i.e it wont have a student_id column) for that we
    //Need to declare this mappedBy property with value as variable name of passport in student class
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

    public Passport(String number){
        this.number  = number;
    }
    public Passport(){

    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\''+
                '}';
    }
}
