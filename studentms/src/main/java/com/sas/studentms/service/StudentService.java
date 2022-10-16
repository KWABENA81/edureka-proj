package com.sas.studentms.service;

import com.sas.studentms.model.Student;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements IStudentService {
    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Set<Student> all() {
        return null;
    }

    public Student save(Student student) {
        return student;
    }
}
