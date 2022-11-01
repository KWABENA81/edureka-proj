insert into  ENROLL (id,ENROLLMENT) values (1,'ACTIVE');
insert into ENROLL (id, ENROLLMENT) values (2, 'INACTIVE');
insert into  ENROLL (id,ENROLLMENT) values (3,'FULLTIME');
insert into  ENROLL (id,ENROLLMENT) values (4,'PARTTIME');
insert into  ENROLL (id,ENROLLMENT) values (5,'DOMESTIC');
insert into  ENROLL (id,ENROLLMENT) values (6,'FOREIGN');

insert into  STUDENT (ID,FIRSTNAME,LASTNAME,STUDENTID,USERNAME,PASSWD) values (1,'John', 'Doe', '09990','jdoe','password098');
insert into  STUDENT (ID,FIRSTNAME,LASTNAME,STUDENTID,USERNAME,PASSWD) values (2,'Johnny', 'Doe', '09991','jydoe','password098');
insert into  STUDENT (ID,FIRSTNAME,LASTNAME,STUDENTID,USERNAME,PASSWD) values (3,'James', 'Dick', '09992','jddick','password098');
insert into  STUDENT (ID,FIRSTNAME,LASTNAME,STUDENTID,USERNAME,PASSWD) values (4,'Jack', 'Bill', '09994','jbill','password098');

insert into STUDENT_ENROLLMENTS values(1, 6);
insert into STUDENT_ENROLLMENTS values( 1, 3);
insert into STUDENT_ENROLLMENTS values( 2, 5);
insert into STUDENT_ENROLLMENTS values( 2, 4);
insert into STUDENT_ENROLLMENTS values( 3, 2);
insert into STUDENT_ENROLLMENTS values( 4, 2);

select * from STUDENT ;
