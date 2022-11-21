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
//    @Column(name = "ID", nullable = false)
    private Long id;
    //  @Column(name = "FIRSTNAME", nullable = false, length = 100)
    private String firstName;

    //   @Column(name = "LASTNAME", nullable = false, length = 100)
    private String lastName;

    //  @Column(name = "STUDENTID", nullable = false, unique = true, length = 30)
    private String studentId;

    //   @Column(name = "USERNAME", nullable = false, unique = true, length = 10)
    private String username;

    //  @Column(name = "PASSWD", nullable = false, length = 512)
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
