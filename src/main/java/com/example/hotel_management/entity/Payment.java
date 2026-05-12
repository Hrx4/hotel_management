package com.example.hotel_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cardHolderName;
	@Column(length = 16)
	private String cardNumber;
	@Column(nullable = false)
	private int cvv;
	@Column(nullable = false)
	private int expiryMonth;
	@Column(nullable = false)
	private int expiryDate;
	private String billingAddress;

	@OneToOne(mappedBy = "payment")
	private Booking bookingId;
}
