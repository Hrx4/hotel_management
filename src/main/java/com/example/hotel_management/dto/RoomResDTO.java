package com.example.hotel_management.dto;

import java.util.Set;

import com.example.hotel_management.entity.RoomAmenities;
import com.example.hotel_management.entity.RoomType;

import lombok.Data;


@Data
public class RoomResDTO {
	private Long id;
	private RoomType type;
	private int roomNumber;
	private float price;
	private int adultOccupancy;
	private int childOccupancy;
	private Set<RoomAmenities> roomAmenities;
}
