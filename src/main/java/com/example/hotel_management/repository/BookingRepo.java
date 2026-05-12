package com.example.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_management.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
