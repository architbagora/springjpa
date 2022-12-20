package com.archit.springbootJPAin28minscourse.entity.inheritance;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class FullTimeEmployee extends Employee{
    private BigDecimal salary;

    public FullTimeEmployee(String name , BigDecimal salary){
        super(name);
        this.salary = salary;
    }




}
