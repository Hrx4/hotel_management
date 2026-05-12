package com.example.hotel_management.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")

@Getter
@Setter
@ToString(exclude = "bookings")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
	private String customerName;
	@Column(nullable = false , unique = true)
    private String userName;
    @Column(length=8, nullable=false)
    private String password;
	@Column(nullable = false)
    private String email;
	@Column(unique = true)
	private String phoneNumber;
	@Column(nullable = true)
    private String address;
    @OneToMany(mappedBy = "customer" , cascade = { CascadeType.REMOVE , CascadeType.MERGE , CascadeType.PERSIST} , orphanRemoval = true)
	private final List<Booking> bookings = new ArrayList<>();

}
