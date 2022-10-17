package com.sas.studentms.service;

import com.sas.studentms.model.Student;

import java.util.Collection;
import java.util.Set;

public interface IStudentService {
    boolean delete(Integer id);

    Set<Student> all();
    Collection<Student> findAll();

    Student findById(Integer id);

    Student create(Student student);

    Student update(Student student);

}
