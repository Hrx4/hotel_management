package com.example.hotel_management.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management.dto.BookingReqDTO;
import com.example.hotel_management.dto.BookingResDTO;
import com.example.hotel_management.entity.Booking;
import com.example.hotel_management.mapper.BookingMapper;
import com.example.hotel_management.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/add")
	public ResponseEntity<BookingResDTO> createBooking(@Valid @RequestBody BookingReqDTO dto){
		BookingResDTO booking = bookingService.createBooking(dto);
		return new ResponseEntity<BookingResDTO>(booking , HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BookingResDTO>> getAllBookings(){
		List<BookingResDTO> bookings = bookingService.allBookings();
		return new ResponseEntity<List<BookingResDTO>>(bookings , HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id){
		bookingService.deleteBooking(id);
		return new ResponseEntity<>("Booking successfully deleted for the id : "+id , HttpStatus.OK);
	}

}
