package com.sas.studentms.service;

import com.sas.studentms.model.Student;

import java.util.Set;

public interface IStudentService {
    boolean delete(Integer id);

    Set<Student> all();
}
