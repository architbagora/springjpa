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

        //THIS WONT BE FLUSED TO DB
        student2.setName("Angular JS in 100 steps - Updated AGAIN");

        //quries fired for only student2
        entityManager.flush();
    }

    public void someOperationsToUnderstandPersistanceContext() {
        //DATABASE Operation1 - retrive student
        Student student = entityManager.find(Student.class, 20001l);
        //Persistance context (student)

        //IF @Transactional is removed this will throw error , in hibernate terminology, Session=Persistence context
        //DATABASE Operation2 - retrive passport
        Passport passport = student.getPassport();
        //Persistance context (student,passport)

        //DATABASE Opertaion3 - update passport
        //log.info(passport.getNumber());
        passport.setNumber("LFNHWOWIDNHWODBN");
        //Persistance context (student,passport++)

        student.setName("ADAKDBNAKDBNAKJ");
        //Persistance context (student++,passport++)
    }


    //Transactional is at class level here
    @Transactional
    public void testTransactional(long studentId) throws Exception {
        Student student = entityManager.find(Student.class, studentId);

        student.setName("CHANGED NAME");

        //MAKE SURE DB QUERY IS FIRED
        entityManager.flush();

        student.setName("CHANGED NAME AGAIN");
        //Exception after a DB flush
        throw new Exception("Error happened after DB FLush");
    }


}
