package com.archit.springbootJPAin28minscourse.repository;

import com.archit.springbootJPAin28minscourse.entity.Passport;
import com.archit.springbootJPAin28minscourse.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Transactional
@Repository
public class StudentRepository {
    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {
        if(student.getId() == null){
            entityManager.persist(student);
        }
        else{
            entityManager.merge(student);
        }
        return student;
    }


    public void saveStudentWIthPassport(){
        Passport passport = new Passport("Z12235678");
        //NEED TO SAVE PASSPORT HERE TO AVOID : org.hibernate.TransientPropertyValueException:
        entityManager.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);

        //HIBERNATE IS LAZY IT WILL NOT SAVE ABOVE 2 ENTITIES TILL HERE, WILL CALL SEQUENCE ONLY
    }



    public void deleteById(Long id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    public void palyWithEntityManager(){
        Student student1 = new Student("Web services in 100 steps");
        entityManager.persist(student1);

        Student student2 = new Student("Angular JS in 100 steps");
        entityManager.persist(student2);

        //When actually the quries are fired
        entityManager.flush();

        student1.setName("Web services in 100 steps - Updated");

        student2.setName("Angular JS in 100 steps - Updated");

        //Student1 is reset now.
        entityManager.refresh(student1);

        //Entity manager is will detach and stop tracking it.
        entityManager.detach(student2);

        //quries fired for only student2
        entityManager.flush();
    }

}
