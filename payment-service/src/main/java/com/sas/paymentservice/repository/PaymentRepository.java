package com.sas.paymentservice.repository;

import com.sas.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByRegisterId(Integer id);
}
