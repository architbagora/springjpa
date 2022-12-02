package com.archit.springbootJPAin28minscourse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;


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

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
