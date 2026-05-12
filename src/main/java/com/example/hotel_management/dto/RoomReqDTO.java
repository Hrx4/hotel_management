package com.example.hotel_management.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.example.hotel_management.entity.RoomAmenities;
import com.example.hotel_management.entity.RoomType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomReqDTO {
	@NotNull
	private RoomType type;
	private int roomNumber;
	private BigDecimal price;
	private int adultOccupancy;
	private int childOccupancy;
	@NotNull
	private Set<RoomAmenities> roomAmenities;
}
