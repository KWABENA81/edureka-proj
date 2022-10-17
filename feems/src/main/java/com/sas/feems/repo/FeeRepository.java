package com.sas.feems.repo;

import com.sas.feems.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {
//    @Query("SELECT f FROM Fee f WHERE f.student=(:student)")
//    Collection<Fee> findByStudent(@Param("student") Student student);
}

