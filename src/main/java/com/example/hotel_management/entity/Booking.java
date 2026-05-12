package com.example.hotel_management.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Positive
	private BigDecimal actualPrice;
	
	@Positive
	private BigDecimal paid=BigDecimal.valueOf(0);
	
	@Column(nullable = false)
	@Positive
	private BigDecimal tax;
	
	@Column(nullable = false)
	private LocalDate checkInDate;
	
	@Column(nullable = false)
	private LocalDate checkOutDate;
	
	private String specialReq;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentOptions paymentOptions;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id" , nullable = false)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id" , nullable = false)
	private Room room;
	
	@OneToOne(cascade = {CascadeType.ALL} , orphanRemoval = true)
	@JoinColumn(name = "payment_id")
	private Payment payment;
}
