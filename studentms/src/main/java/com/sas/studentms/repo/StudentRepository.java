package com.sas.studentms.repo;

import com.sas.studentms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);

    Optional<Student> findByStudentId(String studentId);

    Boolean delete(Integer id);
}
