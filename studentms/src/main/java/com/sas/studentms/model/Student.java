package com.sas.studentms.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STUDENT")
public class Student implements Comparable<Student> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;
    @Column(name = "studentId", nullable = false, unique = true, length = 30)
    private String studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getFirstName(),
                student.getFirstName()) && getLastName().equals(student.getLastName())
                && getStudentId().equals(student.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getStudentId());
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
