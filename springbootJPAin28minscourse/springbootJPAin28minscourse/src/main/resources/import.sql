--THis is needed only for JPA things

INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) values (10001, 'ARCHIT','glasgow', now());
INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) values (10002, 'Ranga','glasgow', now());
INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) values (10003, 'Shashank','glasgow', now());


INSERT INTO COURSE(id,name) values(10001,'jpa in 50 steps');
INSERT INTO COURSE(id,name) values(10002,'Spring in 50 steps');
INSERT INTO COURSE(id,name) values(10003,'Spring Boot in 50 steps');

insert into passport (id,number) values (40001, 'E123456');
insert into passport (id,number) values (40002, 'F123456');
insert into passport (id,number) values (40003, 'G123456');

insert into student (id,name,PASSPORT_ID) values (20001, 'ranga',40001);
insert into student (id,name,PASSPORT_ID) values (20002, 'Adam',40002);
insert into student (id,name,PASSPORT_ID) values (20003, 'Jane',40003);

insert into student_course(student_id, course_id) values (20001,10001);
insert into student_course(student_id, course_id) values (20002,10001);
insert into student_course(student_id, course_id) values (20003,10001);
insert into student_course(student_id, course_id) values (20001,10003);

insert into review(id, rating, description,course_id) values(50001, '5','Great course',10001)
insert into review(id, rating, description,course_id) values(50002, '3','Awesomme course',10001)
insert into review(id, rating, description,course_id) values(50003, '5','Good course',10002)

