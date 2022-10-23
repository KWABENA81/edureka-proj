create table STUDENTDB.PUBLIC.STUDENT (
    ID        integer generated by default as identity  (exhausted),
    FIRSTNAME VARCHAR2(100) not null,
    LASTNAME  VARCHAR2(100) not null,
    STUDENTID VARCHAR2(30)  not null
        constraint "UNIQUE_pk"
            unique,
    constraint "STUDENT_pk"
        primary key (ID)
);

insert into  STUDENTDB.PUBLIC.STUDENT (FIRSTNAME, LASTNAME, STUDENTID) values ('John', 'Doe', '09990');
insert into STUDENTDB.PUBLIC.STUDENT (FIRSTNAME, LASTNAME, STUDENTID) values ('Jane', 'Doe', '09900');
insert into STUDENTDB.PUBLIC.STUDENT (FIRSTNAME, LASTNAME, STUDENTID) values ('Rocky', 'Balboa', '09930');

insert into STUDENTDB.PUBLIC.STUDENT (FIRSTNAME, LASTNAME, STUDENTID) values ('RockIE', 'Edwards', '009930');

select * from STUDENT ;