package com.archit.springbootJPAin28minscourse.entity.inheritance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    Employee(String name) {
        this.name = name;
    }

}
