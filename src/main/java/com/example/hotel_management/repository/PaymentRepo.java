package com.example.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_management.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
