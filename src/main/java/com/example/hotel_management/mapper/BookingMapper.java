package com.example.hotel_management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.hotel_management.dto.BookingReqDTO;
import com.example.hotel_management.dto.BookingResDTO;
import com.example.hotel_management.entity.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
	
	BookingResDTO toBookingResDTO (Booking booking);
	List<BookingResDTO> toBookingResDTOs (List<Booking> booking);

	@Mapping(target = "id" , ignore = true)
	@Mapping(target = "payment" , ignore = true)
	Booking toEntity (BookingReqDTO reqDTO);
}
