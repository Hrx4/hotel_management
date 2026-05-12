package com.example.hotel_management.dto;

import java.time.LocalDate;

import com.example.hotel_management.entity.PaymentOptions;

import lombok.Data;

@Data
public class BookingResDTO {
	private Long bookingId;
	private Long roomId;
	private Long customerId;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private String specialReq;
	private PaymentOptions paymentOptions;
}
