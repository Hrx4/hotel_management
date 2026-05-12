package com.example.hotel_management;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hotel_management.dto.BookingReqDTO;
import com.example.hotel_management.dto.BookingResDTO;
import com.example.hotel_management.dto.CustomerReqDTO;
import com.example.hotel_management.dto.CustomerResDTO;
import com.example.hotel_management.dto.RoomReqDTO;
import com.example.hotel_management.dto.RoomResDTO;
import com.example.hotel_management.entity.Booking;
import com.example.hotel_management.entity.Customer;
import com.example.hotel_management.entity.Room;

@SpringBootApplication
public class HotelManagementApplication {
//	@Mapper(componentModel = "spring")
//	public interface RoomMapper {
//		List<RoomResDTO> toRoomResDTOs(List<Room> rooms);
//	    @Mapping(target = "bookings", ignore = true)
//	    @Mapping(target = "id" , ignore = true)
//		Room toEntity(RoomReqDTO roomReqDTO);
//		RoomResDTO toRoomResDTO (Room room);
//		
//	}
//	
//	@Mapper(componentModel = "spring")
//	public interface CustomerMapper {
//
//	    @Mapping(target = "id", ignore = true)
//	    @Mapping(target = "bookings", ignore = true)
//	    Customer toEntity(CustomerReqDTO reqDto);
//	    @Mapping(target = "password" , ignore = true)
//	    CustomerResDTO toResponseDto(Customer customer);
//	    @Mapping(target = "password" , ignore = true)
//	    List<CustomerResDTO> toCustomerResDTOs(List<Customer> customers);
//	}
//	
//	@Mapper(componentModel = "spring")
//	public interface BookingMapper {
//		
//		BookingResDTO toBookingResDTO (Booking booking);
//		List<BookingResDTO> toBookingResDTOs (List<Booking> booking);
//
//		@Mapping(target = "Id" , ignore = false)
//		@Mapping(target = "paymentId" , ignore = true)
//		Booking toEntity (BookingReqDTO reqDTO);
//	}
//	
	
	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

}
