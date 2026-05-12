package com.example.hotel_management.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "room")
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoomType type;
	@Column(unique = true , nullable = false)
	private int roomNumber;
	@Positive
	private BigDecimal price;
	private int adultOccupancy=1;
	private int childOccupancy = 0;
	@ElementCollection(targetClass = RoomAmenities.class)
	@Enumerated(EnumType.STRING)
	private Set<RoomAmenities> roomAmenities;
	@OneToMany(mappedBy = "room" , cascade = {CascadeType.REMOVE , CascadeType.MERGE , CascadeType.PERSIST} , orphanRemoval = true)
	private final List<Booking> bookings = new ArrayList<>();
	
}



