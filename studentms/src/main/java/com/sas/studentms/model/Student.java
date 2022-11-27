package com.sas.studentms.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student implements Comparable<Student> {

    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    private Long id;

    private String firstName;

    private String lastName;

    private String studentId;

    private String username;

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
