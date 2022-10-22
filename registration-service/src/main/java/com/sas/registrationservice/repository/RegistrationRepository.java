package com.sas.registrationservice.repository;

import com.sas.registrationservice.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
}
