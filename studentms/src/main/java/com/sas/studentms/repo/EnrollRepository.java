package com.sas.studentms.repo;

import com.sas.studentms.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll, Long> {

    @Query("SELECT e FROM Enroll e WHERE e.enrollment=(:enrollment)")
    Optional<Enroll> findByEnrollment(@Param("enrollment") String enrollment);
}
