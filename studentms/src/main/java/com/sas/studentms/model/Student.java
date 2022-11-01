package com.sas.studentms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student implements Comparable<Student> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "FIRSTNAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false, length = 100)
    private String lastName;

    @Column(name = "STUDENTID", nullable = false, unique = true, length = 30)
    private String studentId;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 10)
    private String username;

    @Column(name = "PASSWD", nullable = false, length = 512)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Enroll> enrollments;

    @Override
    public int compareTo(Student st) {
        int value = this.lastName.compareTo(st.lastName);
        if (value == 0) {
            value = this.firstName.compareTo(st.firstName);
        }
        if (value == 0) {
            value = this.studentId.compareTo(st.studentId);
        }
        return value;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }

}
