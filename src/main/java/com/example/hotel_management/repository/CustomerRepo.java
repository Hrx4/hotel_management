package com.example.hotel_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_management.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer , Long> {
	public Optional<Customer> findByUserName(String userName);
}
