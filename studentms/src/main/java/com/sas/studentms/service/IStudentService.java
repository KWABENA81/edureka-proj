package com.sas.studentms.service;

import com.sas.studentms.model.Enroll;
import com.sas.studentms.model.Student;

import java.util.Collection;
import java.util.List;

public interface IStudentService {

    Collection<Student> findAll();

    Student findById(Long id);

    List<Student> getStudents();

    Enroll saveEnrollment(Enroll enroll);

    void addEnrollment(String username, String enrollment);
}


