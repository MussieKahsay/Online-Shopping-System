package edu.miu.cs.cs425.repository;

import edu.miu.cs.cs425.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
