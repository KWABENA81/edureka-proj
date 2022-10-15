package com.sas.studentms.model;


import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student implements Comparable<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public Integer getId() {
        return id;
    }
}
