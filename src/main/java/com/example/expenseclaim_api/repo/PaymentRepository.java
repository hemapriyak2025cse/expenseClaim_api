package com.example.expenseclaim_api.repo;

import com.example.expenseclaim_api.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
