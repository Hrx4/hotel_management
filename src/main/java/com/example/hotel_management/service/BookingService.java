package com.example.hotel_management.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.hotel_management.HotelManagementApplication.BookingMapper;
import com.example.hotel_management.dto.BookingReqDTO;
import com.example.hotel_management.dto.BookingResDTO;
import com.example.hotel_management.entity.Booking;
import com.example.hotel_management.entity.Customer;
import com.example.hotel_management.entity.Room;
import com.example.hotel_management.exception.BookingNotFoundException;
import com.example.hotel_management.exception.CustomerNotFoundExceptions;
import com.example.hotel_management.exception.RoomNotFoundException;
import com.example.hotel_management.mapper.BookingMapper;
import com.example.hotel_management.repository.BookingRepo;
import com.example.hotel_management.repository.CustomerRepo;
import com.example.hotel_management.repository.RoomRepo;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
	@Autowired
	BookingRepo bookingRepo;
	@Autowired 
	CustomerRepo customerRepo;
	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	BookingMapper bookingMapper;
	
	@Transactional
	public BookingResDTO createBooking(BookingReqDTO dto) {
		Customer customer = customerRepo.findById(dto.getCustomerId()).
				orElseThrow(()->new CustomerNotFoundExceptions("Customer doesnot exist of id : "+dto.getCustomerId()));
		Room room = roomRepo.findById(dto.getRoomId()).
				orElseThrow(()-> new RoomNotFoundException("Room doesnot exist of id : "+dto.getRoomId()));
		
		Booking booking = bookingMapper.toEntity(dto);
		booking.setCustomer(customer);
		booking.setRoom(room);
		BigDecimal price = room.getPrice();
		BigDecimal tax = price.multiply(BigDecimal.valueOf(0.18));
		booking.setActualPrice(price);
		booking.setTax(tax);
		Booking createdBooking = bookingRepo.save(booking);
		return bookingMapper.toBookingResDTO(createdBooking);
	}
	
	public List<BookingResDTO> allBookings(){
		List<Booking> bookings = bookingRepo.findAll();
		return bookingMapper.toBookingResDTOs(bookings);
	}
	
	public void deleteBooking(Long id) {
		Booking deletedBooking = bookingRepo.findById(id)
				.orElseThrow(()->new BookingNotFoundException("Booking does not exist for the id : "+id));
		bookingRepo.delete(deletedBooking);
	}
	
	
}
