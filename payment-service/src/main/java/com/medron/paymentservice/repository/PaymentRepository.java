package com.medron.paymentservice.repository;

import com.medron.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID>{
}
