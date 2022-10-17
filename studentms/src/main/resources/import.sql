create table student
(
    firstname VARCHAR not null,
    lastname  VARCHAR not null,
    studentId VARCHAR not null unique
);
insert into student (firstname, lastname, studentId) values ('John', 'Doe', '0908976');
insert into student (firstname, lastname, studentId) values ('Jane', 'Doe', '0938976');
insert into student (firstname, lastname, studentId) values ('Rocky', 'Balboa', '0904976');
insert into student (firstname, lastname, studentId) values ('Elizabeth', 'Jane', '0908676');


select * from STUDENT;
