package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String rating;

    private String description;

    @ManyToOne
    private Course course;

    public Review(String rating, String description){
        this.description = description;
        this.rating = rating;
    }
    public Review(){

    }
}
