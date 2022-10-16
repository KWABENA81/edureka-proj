package com.sas.feems.repo;

import com.sas.feems.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {
}

