package com.archit.springbootJPAin28minscourse.entity.inheritance;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor

public class ParttimeEmployee  extends Employee{

    public ParttimeEmployee(String name , BigDecimal hourlyWage){
        super(name);
        this.hourlyWage = hourlyWage;
    }

    private BigDecimal hourlyWage;




}
