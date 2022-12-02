package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    public Passport(String number){
        this.number  = number;
    }
    public Passport(){

    }
}
