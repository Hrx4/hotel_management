package com.example.hotel_management.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hotel_management.dto.RoomReqDTO;
import com.example.hotel_management.dto.RoomResDTO;
import com.example.hotel_management.entity.Room;
import com.example.hotel_management.entity.RoomType;
import com.example.hotel_management.mapper.RoomMapper;
import com.example.hotel_management.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@PostMapping("/add")
	public ResponseEntity<RoomResDTO> addRoom(@Valid @RequestBody RoomReqDTO roomReqDTO){
		System.out.println(roomReqDTO);
		RoomResDTO createdRoom = roomService.addRoom(roomReqDTO);
		return new ResponseEntity<>(createdRoom , HttpStatus.CREATED);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<RoomResDTO>> getRooms(
			@RequestParam LocalDate checkoutdate,
			@RequestParam LocalDate checkindate,
			@RequestParam BigDecimal price,
			@RequestParam RoomType roomtype,
			@RequestParam int adultoccupancy ,
			@RequestParam int childOccupancy){
		
		List<RoomResDTO> rooms = roomService.getAvailableRooms(checkoutdate, checkindate, 
				price, roomtype, adultoccupancy, childOccupancy);
		System.out.println("hi");
		return new ResponseEntity<>(rooms , HttpStatus.FOUND);
		
	}

	@GetMapping
	public ResponseEntity<List<RoomResDTO>> getAllRooms(){
		List<RoomResDTO> rooms = roomService.getRooms();
		return new ResponseEntity<List<RoomResDTO>>(rooms , HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoomResDTO> getRoom(@PathVariable Long id){
		RoomResDTO room = roomService.getRoom(id);
		return new ResponseEntity<>(room , HttpStatus.FOUND);
	}
}
